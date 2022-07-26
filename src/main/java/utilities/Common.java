package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Common {
	WebDriver driver;

	@FindBy(xpath = "//li[@data-testid='title-details-releasedate']//child::li//a[contains(@href,'releaseinfo')]")
	WebElement releaseInfoIMDB;
	@FindBy(xpath = "//a[contains(text(),'India')]//parent::td//following-sibling::td[1]")
	WebElement releaseDateIMDB;
	@FindBy(xpath = "//th//div[contains(text(),'Release date')]//following::td[1]//li")
	WebElement releaseDateWiki;

	public Common(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getReleaseDate(String source) throws InterruptedException {
		String releaseDate = "";
		if (source.equalsIgnoreCase("imdb")) {
			releaseInfoIMDB.click();
			Thread.sleep(4000);
			releaseDate = releaseDateIMDB.getText();
		} else if (source.equalsIgnoreCase("wiki")) {
			releaseDate = releaseDateWiki.getText();
		}
		return releaseDate;
	}

}
