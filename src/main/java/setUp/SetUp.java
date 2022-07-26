package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
	WebDriver driver;

	@BeforeTest
	public void start() {
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
