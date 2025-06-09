package sania.base;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sania.utils.ConfigReader;

public class BaseTest {

	public WebDriverWait wait;
	protected WebDriver driver;

	public void initializeBrowser() {
		String browser = ConfigReader.get("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser not supported: " + browser);
		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));
	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
