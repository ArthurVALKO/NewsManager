/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Categorie {
    private String nomCategorie;
    private ArrayList<Site> listeSites = new ArrayList<Site>();
    
    public Categorie(){
        this.nomCategorie = "";
    }
    
    public Categorie(String nomCategorie){
        this.nomCategorie = nomCategorie;
    }
    
    public void setNomCategorie(String nomCategorie){
        this.nomCategorie = nomCategorie;
    }
    
    public String getNomCategorie(){
        return this.nomCategorie;
    }
    
    public ArrayList<Site> getListeSites(){
        return listeSites;
    }
    
    public Site getSite(int indice){
        return listeSites.get(indice);
    }
    
    public boolean ajouterSite(String nomSite, String URL, String fluxRSS){
        if(nomSite != null && URL != null && fluxRSS != null){
			try {
				Site site = new Site(nomSite,new URL(URL), new URL(fluxRSS));
	            listeSites.add(site);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return true;
        }else{
            return false;
        }
    }
    
    public boolean supprimerSite(String nomSite){
        for(Site s : listeSites){
            if(s.getNomSite().equals(nomSite)){
                listeSites.remove(s);
                return true;
            }
        }
        return false;
    }
    
}
