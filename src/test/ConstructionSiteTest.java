package test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import model.Site;

import org.junit.Before;
import org.junit.Test;

public class ConstructionSiteTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testActualisationSite() {
		Site siteTest = null;
		try {
			siteTest = new Site(new URL("http://rss.lemonde.fr/c/205/f/3050/index.rss"));
			assertTrue(siteTest.actualiser());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(siteTest.actualiser());
		}
		
	}

}
