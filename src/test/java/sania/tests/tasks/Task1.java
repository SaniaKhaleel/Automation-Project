package sania.tests.tasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import sania.utils.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sania.base.BaseTest;

public class Task1 extends BaseTest {
	@Test
	public void getUrl() {

		initializeBrowser();

		// Launch the browser and open Google using .get()
		// This is typically used for the **initial page load**
		// should be https://www.google.com
		driver.get(ConfigReader.get("url"));
		wait.until(ExpectedConditions.titleContains("Google"));
		// Asserts that the title contains "Google".
		Assert.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");

		// print the title of the page
		System.out.println("Google Title:" + driver.getTitle());

		// Navigates to Amazon India's Website using navigate().to()
		// Useful for chaining, history support, or changing between sites
		// should be https://www.amazon.in
		driver.navigate().to(ConfigReader.get("baseUrl"));

		// Waits until the title conatains "Amazon'(explicit wait)
		wait.until(ExpectedConditions.titleContains("Amazon"));

		// Assert that the title conatains "Amazon";
		Assert.assertTrue(driver.getTitle().contains("Amazon"), "Title does not contains 'Amazon'");

		// print the Amazon title
		System.out.println("amazon Title:" + driver.getTitle());

		// Now use navigate().back() and forward()
		// navigate back to the previous page(Google)
		driver.navigate().back();
		wait.until(ExpectedConditions.titleContains("Google"));
		System.out.println("After Back():" + driver.getTitle());

		// Goes forward to Amazon
		driver.navigate().forward();
		wait.until(ExpectedConditions.titleContains("Amazon"));
		System.out.println("After forward():" + driver.getTitle());

	}

}