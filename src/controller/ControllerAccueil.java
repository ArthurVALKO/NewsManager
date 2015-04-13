/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Categorie;
import model.ListeCategorie;
import vue.FrmFenetrePrincipale;

/**
 *
 * @author Esteban
 */
public class ControllerAccueil {
    private ArrayList<Categorie> listeCategorieAccueil = new ArrayList<Categorie>();
    private FrmFenetrePrincipale fen = new FrmFenetrePrincipale();
    private ListeCategorie liste = new ListeCategorie();
    
    public ControllerAccueil(ListeCategorie liste, FrmFenetrePrincipale fenetre){
        this.fen = fenetre;
        this.liste = liste;
    }

    public ArrayList<Categorie> getListeCategorieAccueil() {
        return listeCategorieAccueil;
    }

    public FrmFenetrePrincipale getFen() {
        return fen;
    }

    public ListeCategorie getListe() {
        return liste;
    }

    public void setListeCategorieAccueil(ArrayList<Categorie> listeCategorieAccueil) {
        this.listeCategorieAccueil = listeCategorieAccueil;
    }

    public void setFen(FrmFenetrePrincipale fen) {
        this.fen = fen;
    }

    public void setListe(ListeCategorie liste) {
        this.liste = liste;
    }
    
    
}
