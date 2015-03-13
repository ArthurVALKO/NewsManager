/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Esteban
 */
public class News {
    private String nomNews;
    private String description;
    private String adresse;

    public News() {
        this.nomNews = "";
        this.description = "";
        this.adresse = "";
    }
    
    public News(String nomNews, String description, String adresse) {
        this.nomNews = nomNews;
        this.description = description;
        this.adresse = adresse;
    }
    
    public String getNomNews() {
        return nomNews;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNomNews(String nomNews) {
        this.nomNews = nomNews;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
