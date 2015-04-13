package model;
/**
*
* @author Arthur
* 
*/
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RSSAnaliseur {
	
	private XPathFactory fabrique = XPathFactory.newInstance();
	private XPath xpath = fabrique.newXPath();
	private XPathExpression exp;
	private DocumentBuilder builder;
	private Document doc;
	
	public RSSAnaliseur(Site site) {
		try {
			captureFluxRSS(site.getFluxRSS());
			site.setNomSite(evaluerDocument(doc, "//title"));
			site.setURL(new URL(evaluerDocument(doc, "//link")));
			//recuperation de la liste Item 
			NodeList listItems = colecteItems(doc);
			site.setListeNews(convertionItemEnNews(listItems));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document captureFluxRSS(URL url){
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
		domFactory.setNamespaceAware(true);
		
			try {
				builder = domFactory.newDocumentBuilder();
				doc = builder.parse(url.openStream());
			} catch (SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return doc;
	}

	private ArrayList<News> convertionItemEnNews(NodeList listItems) {
		ArrayList<News> listNews = new ArrayList<News>();
		for (int i = 0; i < listItems.getLength(); i++) {
			//Si le noeud n'ai pas vide on recuper son comptenue sou la forme element.
			if (listItems.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) listItems.item(i);
	            News nouvelle = new News();
	            nouvelle.setAdresse(item.getElementsByTagName("link").item(0).getTextContent());
	            nouvelle.setDescription(item.getElementsByTagName("description").item(0).getTextContent());
	            nouvelle.setNomNews(item.getElementsByTagName("title").item(0).getTextContent());
	            
	            if((Element)item.getElementsByTagName("enclosure").item(0) != null)
	            	nouvelle.setUrlImage(((Element)item.getElementsByTagName("enclosure").item(0)).getAttribute("url"));

	            listNews.add(nouvelle);
	        }
	    }
		return listNews;
		
	}
	
	private NodeList colecteItems(Document document) {
		NodeList list = null;
		try{
			//Evaluation de l'expression XPath
			xpath = fabrique.newXPath();
			exp = xpath.compile("//item");
			list = (NodeList)exp.evaluate(document,XPathConstants.NODESET);
		}catch(XPathExpressionException xpee){
			xpee.printStackTrace();
			
		}
		return list;
	}
	
	

	private String evaluerDocument(Document document, String expression) {
		String resu = null;
		try {
			xpath = fabrique.newXPath();
			exp = xpath.compile(expression);
			resu = exp.evaluate(document);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resu;
	}

}
