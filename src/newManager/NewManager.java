package newManager;

import model.ListeCategorie;
import model.News;


public class NewManager {

	public static void main(String[] args) {
		ListeCategorie lstCat = new ListeCategorie();
        lstCat.ajoutCategorie("Journaux");
        lstCat.ajoutCategorie("News");
        lstCat.getCategorie("Journaux").ajouterSite("Le monde", "http://www.lemonde.fr/", "http://rss.lemonde.fr/c/205/f/3050/index.rss");
        System.out.println(lstCat.getCategorie("Journaux").getSite(0).toString());
        lstCat.getCategorie("Journaux").getSite(0).ajouterNews();
        for(News n: lstCat.getCategorie("Journaux").getSite(0).getListeNews() )
            System.out.println(n.toStringImage());
	}

}
