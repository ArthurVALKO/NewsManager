package model;
import org.w3c.dom.*; 
import org.xml.sax.*;
import javax.xml.xpath.*; 
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe (modifiable selon les besoins) permettant de recuperer, depuis une adresse de flux rss,
 *  les titres, adresses et descriptions des dernieres news.
 * @author riviere
 * @version 1.0
 * Reprise d'une version de la classe NodeSetXPath d�veloop�e par Ioan Calapodescu
 * http://java.developpez.com/telecharger/detail/id/1097/NodeSetXPath-java
 */
public class RSSAgent{

	private String address;
	
	/**
	 * Constructeur de la classe RSSAgent.
	 * @param address represente l'adresse du flux rss
	 */
        public RSSAgent(){
            address = "";
        }
        
	public RSSAgent(String address){
		this.address=address;
	}
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Methode renvoyant une liste des titres de chaque news
	 * @return une liste des titres de chaque news ou une liste vide 
	 * si aucun titre n'est disponible
	 */
	public ArrayList<String> getTitle(){
		ArrayList<String> allTitle=new ArrayList<String>();
		try{
			URL url = new URL(getAddress());
			String expression = "//item/title";
			NodeList list = evaluer(url.openStream(),expression);

			if(list != null){
				//Titres des articles disponibles a l'adresse address
				for(int i=0; i<list.getLength(); i++){
					Node node = list.item(i);
					allTitle.add(node.getTextContent());	
				}	
			}

			return allTitle;
		}catch(Exception e){
			e.printStackTrace();	
			return allTitle;
		}
	}

	/**
	 * Methode renvoyant une liste des descriptions de chaque news
	 * @return une liste des descriptions de chaque news ou une liste vide 
	 * si aucune description n'est disponible
	 */
	public ArrayList<String> getDescription(){
		ArrayList<String> allDescription=new ArrayList<String>();
		try{
			URL url = new URL(getAddress());
			String expression = "//item/description";
			NodeList list = evaluer(url.openStream(),expression);

			if(list != null){
				//Descriptions des articles disponibles a l'adresse address
				for(int i=0; i<list.getLength(); i++){
					Node node = list.item(i);
					allDescription.add(node.getTextContent());	
				}	
			}

			return allDescription;
		}catch(Exception e){
			e.printStackTrace();	
			return allDescription;
		}
	}
		
		public ArrayList<String> getImage(){
			ArrayList<String> allDescription=new ArrayList<String>();
			try{
				URL url = new URL(getAddress());
				String expression = "//item/enclosure/url";
				
				NodeList list = evaluer(url.openStream(),expression);

				if(list != null){
					//Descriptions des articles disponibles a l'adresse address
					for(int i=0; i<list.getLength(); i++){
						Node node = list.item(i);
						allDescription.add(node.getTextContent());	
					}	
				}

				return allDescription;
			}catch(Exception e){
				e.printStackTrace();	
				return allDescription;
			}
	}

	/**
	 * Methode renvoyant une liste des liens de chaque news
	 * @return une liste des descriptions de chaque news ou une liste vide 
	 * si aucun lien n'est disponible
	 */
	public ArrayList<String> getLink(){
		ArrayList<String> allLink=new ArrayList<String>();
		try{
			URL url = new URL(getAddress());
			String expression = "//item/link";
			NodeList list = evaluer(url.openStream(),expression);

			if(list != null){
				//Liens vers les articles disponibles a l'adresse address
				for(int i=0; i<list.getLength(); i++){
					Node node = list.item(i);
					allLink.add(node.getTextContent());	
				}	
			}

			return allLink;
		}catch(Exception e){
			e.printStackTrace();	
			return allLink;
		}
	}

	/**
	 * Methode privee permettant de creer une NodeList a partir d'un flux
	 * et d'une chaine de caractere.
	 * La NodeList cree contient une liste de noeud (Node),
	 *  chaque noeud etant associe a une chaine de caractere recuperee depuis le flux.
	 * @param stream le flux rss a lire
	 * @param expression la chaine de caracteres representant la balise rss a retrouver
	 * @return null si une erreur est survenue
	 */
	private NodeList evaluer(InputStream stream, String expression){
		NodeList list = null;
		try{
			//Creation de la source
			InputSource source = new InputSource(stream);

			//Creation du XPath 
			XPathFactory fabrique = XPathFactory.newInstance();
			XPath xpath = fabrique.newXPath();

			//Evaluation de l'expression XPath
			XPathExpression exp = xpath.compile(expression);
			list = (NodeList)exp.evaluate(source,XPathConstants.NODESET);

		}catch(XPathExpressionException xpee){
			xpee.printStackTrace();
		}
		return list;
	}

}