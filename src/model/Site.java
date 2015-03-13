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
    private RSSAgent agentRSS;
    private ArrayList<News> listeNews = new ArrayList<News>();

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
    
    public boolean ajouterNews(String nomNews, String description, String adresse){
        agentRSS.setAddress(fluxRSS);
        if(nomNews != null && description != null && adresse != null){
            News news = new News(nomNews, description, adresse);
            listeNews.add(news);
            return true;
        }else{
            return false;
        }
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
}
