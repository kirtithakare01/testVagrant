package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Pages.ImdbPage;
import Pages.WikiPage;
import dataProvider.ConfigFileReader;
import setUp.SetUp;
import utilities.Common;


public class CompareTests extends SetUp{
	WebDriver driver;
	WikiPage wp;
	ImdbPage ip;
	Common cm;
	ConfigFileReader cfr;
	
	public CompareTests() {
		driver = getDriver();
		ip =  new ImdbPage(driver);
		wp = new WikiPage(driver);
		cm = new Common(driver);
		cfr = new ConfigFileReader();
	}
	
	@Test
	@Parameters({"imdbUrl","wikiUrl"})
	public void compareCountryAndReleaseDate(String imdbUrl,String wikiUrl) throws InterruptedException {
		//Launch IMDB URL,search movie and getReleaseDate
		driver.get(imdbUrl);
		ip.searchPushpa(cfr.getMovieTitle());
		String releaseDateIMDB = cm.getReleaseDate(cfr.getSourceOne());
		
		//Launch IMDB URL,search movie and getReleaseDate
		driver.get(wikiUrl);
		wp.searchPushpa(cfr.getMovieTitle());
		String releaseDateWIKI = cm.getReleaseDate(cfr.getSourceTwo());
		
		//Assert that both release dates are equal
		Assert.assertEquals(releaseDateIMDB, releaseDateWIKI);

	}

}
