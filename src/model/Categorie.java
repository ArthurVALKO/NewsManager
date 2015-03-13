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
public class Categorie {
    private String nomCategorie;
    private ArrayList<Site> listeSites = new ArrayList<Site>();
    
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
        return true;
    }
    
    public boolean supprimerSite(String nomSite){
        return true;
    }
    
}
