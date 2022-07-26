package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbPage {
	WebDriver driver;
	@FindBy(css = "input[aria-label='Search IMDb']")
	WebElement searchBoxIMDB;
	@FindBy(xpath = "//div[contains(normalize-space(text()),'Pushpa: The Rise - Part 1')]")
	WebElement searchResultIMDB;

	public ImdbPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchPushpa(String filmName) throws InterruptedException {
		searchBoxIMDB.click();
		searchBoxIMDB.sendKeys(filmName);
		Thread.sleep(3000);
		searchResultIMDB.click();
	}

}
