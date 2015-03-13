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
public class ListeCategorie {
    private ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();
    
    public ArrayList<Categorie> getListCategorie(){
        return listeCategories;
    }
    
    public Categorie getCategorie(int indice){
        return listeCategories.get(indice);
    }
    
    public boolean ajoutCategorie(String nomCategorie){
        return true;
    }
    
    public boolean supprimerCategorie(String nomCategorie){
        return true;
    }
    
    public boolean enregistrer(String nomFichier){
        return true;
    }
    
    public boolean charger(String nomFichier){
        return true;
    }
}
