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
    
    public Categorie getCategorie(String nomCategorie){
        for(Categorie cat: listeCategories){
            if(cat.getNomCategorie().equals(nomCategorie))
                return cat;
        }
        return null;
    }
    
    public boolean ajoutCategorie(String nomCategorie){
        if(nomCategorie != null){
            Categorie cat = new Categorie(nomCategorie);
            listeCategories.add(cat);
            return true;
        }
        return false;
    }
    
    public boolean supprimerCategorie(String nomCategorie){
        for(Categorie cat: listeCategories){
            if(cat.getNomCategorie().equals(nomCategorie)){
                listeCategories.remove(cat);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        String texte = "";
        for(Categorie cat:listeCategories){
            texte += cat.getNomCategorie();
        }
        return texte;
    }
    
    public boolean enregistrer(String nomFichier){
        return true;
    }
    
    public boolean charger(String nomFichier){
        return true;
    }
}
