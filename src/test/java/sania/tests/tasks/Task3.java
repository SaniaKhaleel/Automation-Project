package sania.tests.tasks;

import org.testng.annotations.Test;
import java.time.LocalTime;
import org.testng.SkipException;
import sania.base.BaseTest;
import sania.utils.ConfigReader;
import sania.pages.AmazonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task3 extends BaseTest {

	@Test
	public void clickFilteredProduct() {

		LocalTime currentTime = LocalTime.now();
		LocalTime start = LocalTime.of(15, 0);
		LocalTime end = LocalTime.of(18, 0);

		if (currentTime.isBefore(start) || currentTime.isAfter(end)) {
			throw new SkipException("Test skipped: current time is outside allowed range (3PM to 6PM)");
		}

		initializeBrowser();
		driver.get(ConfigReader.get("baseUrl"));

		AmazonPage amazon = new AmazonPage(driver);

		amazon.searchBox.sendKeys("Hair Oil");
		amazon.searchButton.click();

		for (WebElement link : amazon.productLinks) {
			String productName = link.getText().trim();
			if (!productName.isEmpty()) {
				char firstChar = Character.toUpperCase(productName.charAt(0));
				if (firstChar != 'A' && firstChar != 'B' && firstChar != 'C' && firstChar != 'D') {
					System.out.println("Selected Product: " + productName);
					link.click();
					break;
				}
			}
		}
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		wait.until(ExpectedConditions.visibilityOf(amazon.productTitle));
		System.out.println("Product Title: " + amazon.productTitle.getText());
		System.out.println("Product Price: " + amazon.price.getText());
		System.out.println("Rating: " + amazon.rating.getAttribute("textContent"));
		System.out.println("Reviews: " + amazon.reviewCount.getText());
		System.out.println("Availability: " + amazon.availability.getText().trim());
	}
}
