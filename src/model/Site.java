/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Site {
    private String nomSite;
    private URL url;
    private URL fluxRSS;
    private RSSAgent agentRSS = new RSSAgent();
    private ArrayList<News> listeNews = new ArrayList<News>();

    public boolean actualiser(){
    	RSSAnaliseur rss = new RSSAnaliseur(this);
    	return true;
    }
  

	public Site(){
        this.nomSite = "";
        this.fluxRSS = null;
        this.url = null;
    }
    
    public Site(URL fluxRSS){
    	this.fluxRSS = fluxRSS;
    //	agentRSS.RecuperationInformation(this);
    	
    }
    
    public Site(String nomSite, URL url, URL fluxRSS){
        this.nomSite = nomSite;
        this.url = url;
        this.fluxRSS = fluxRSS;
    }
    
    public String getNomSite() {
        return nomSite;
    }

    public URL getURL() {
        return url;
    }

    public URL getFluxRSS() {
        return fluxRSS;
    }

    public RSSAgent getAgentRSS() {
        return agentRSS;
    }

    public ArrayList<News> getListeNews() {
        return listeNews;
    }
    
    public News getNews(int indice){
        return listeNews.get(indice);
    }
    
    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public void setURL(URL URL) {
        this.url = URL;
    }

    public void setFluxRSS(URL fluxRSS) {
        this.fluxRSS = fluxRSS;
    }

    public void setAgentRSS(RSSAgent agentRSS) {
        this.agentRSS = agentRSS;
    }
    public void setListeNews(ArrayList<News> listeNews) {
		this.listeNews = listeNews;
	}
    
    

    
    public boolean ajouterNews(){
        int i;
        ArrayList<String> listeTitre;
        ArrayList<String> listeDescription;
        ArrayList<String> listeLien;
        ArrayList<String> listeUrlImage;
        agentRSS.setAddress(fluxRSS.toString());
        listeTitre = agentRSS.getTitle();
        listeDescription = agentRSS.getDescription();
        listeLien = agentRSS.getLink();
        listeUrlImage = agentRSS.getImage();
        for(i=0;i<listeTitre.size();i++){
            News news = new News(listeTitre.get(i), listeDescription.get(i), listeLien.get(i));
            listeNews.add(news);
        }
        return true;
    }
    
    public boolean supprimerNews(String nomNews){
        for(News n : listeNews){
            if(n.getNomNews().equals(nomNews)){
                listeNews.remove(n);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Nom du site: " + nomSite + " / URL: " + url + " / Flux RSS: " + fluxRSS;
    }

	
}
