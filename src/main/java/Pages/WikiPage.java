package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {
	WebDriver driver;
	@FindBy(id = "searchInput")
	WebElement searchBoxWiki;
	@FindBy(xpath = "//h3[text()='Pushpa: The Rise']")
	WebElement searchResultWiki;
	@FindBy(xpath = "//th//div[contains(text(),'Release date')]//following::td[1]//li")
	WebElement releaseDateWiki;

	public WikiPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchPushpa(String filmName) throws InterruptedException {
		searchBoxWiki.click();
		searchBoxWiki.sendKeys(filmName);
		Thread.sleep(3000);
		searchResultWiki.click();
	}

}
