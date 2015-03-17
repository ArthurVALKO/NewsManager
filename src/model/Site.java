/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Site {
    private String nomSite;
    private String URL;
    private String fluxRSS;
    private RSSAgent agentRSS = new RSSAgent();
    private ArrayList<News> listeNews = new ArrayList<News>();

    public Site(){
        this.nomSite = "";
        this.fluxRSS = "";
        this.URL = "";
    }
    
    public Site(String nomSite, String URL, String fluxRSS){
        this.nomSite = nomSite;
        this.URL = URL;
        this.fluxRSS = fluxRSS;
    }
    
    public String getNomSite() {
        return nomSite;
    }

    public String getURL() {
        return URL;
    }

    public String getFluxRSS() {
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

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setFluxRSS(String fluxRSS) {
        this.fluxRSS = fluxRSS;
    }

    public void setAgentRSS(RSSAgent agentRSS) {
        this.agentRSS = agentRSS;
    }
    
    public boolean ajouterNews(){
        int i;
        ArrayList<String> listeTitre;
        ArrayList<String> listeDescription;
        ArrayList<String> listeLien;
        ArrayList<String> listeUrlImage;
        agentRSS.setAddress(fluxRSS);
        listeTitre = agentRSS.getTitle();
        listeDescription = agentRSS.getDescription();
        listeLien = agentRSS.getLink();
        listeUrlImage = agentRSS.getImage();
        for(i=0;i<listeTitre.size();i++){
            News news = new News(listeTitre.get(i), listeDescription.get(i), listeLien.get(i), listeUrlImage.get(i));
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
        return "Nom du site: " + nomSite + " / URL: " + URL + " / Flux RSS: " + fluxRSS;
    }
}
