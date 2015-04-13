package newManager;

import vue.FrmFenetrePrincipale;
import model.ListeCategorie;
import model.News;
import model.Site;


public class NewManager {

	public static void main(String[] args) {
		
		
        FrmFenetrePrincipale fenetrePrincipale = new FrmFenetrePrincipale();
		ListeCategorie lstCat = new ListeCategorie();
        lstCat.ajoutCategorie("Journaux");
        lstCat.ajoutCategorie("News");
        
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://rss.lemonde.fr/c/205/f/3050/index.rss");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "https://fr.news.yahoo.com/rss/afrique");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.france24.com/fr/europe/rss/");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/actualites-a-la-une.rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/politique/rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://rss.lemonde.fr/c/205/f/3050/index.rss");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "https://fr.news.yahoo.com/rss/afrique");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.france24.com/fr/europe/rss/");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/actualites-a-la-une.rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/politique/rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://rss.lemonde.fr/c/205/f/3050/index.rss");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "https://fr.news.yahoo.com/rss/afrique");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.france24.com/fr/europe/rss/");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/actualites-a-la-une.rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/politique/rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://rss.lemonde.fr/c/205/f/3050/index.rss");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "https://fr.news.yahoo.com/rss/afrique");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.france24.com/fr/europe/rss/");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/actualites-a-la-une.rss.xml");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://www.leparisien.fr/politique/rss.xml");
        

        long begin = System.currentTimeMillis();
        for(Site s: lstCat.getCategorie("Journaux").getListeSites() ){
        	//System.out.println(s.toString());
           // s.ajouterNews();
            s.actualiser();
           /* System.out.println(s.toString());
            for(News n: s.getListeNews() ){
           		System.out.println(n.toString());
           		System.out.println(n.toStringImage());
           	}*/
        }

        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        fenetrePrincipale.setVisible(true);
        
	
	}

}
