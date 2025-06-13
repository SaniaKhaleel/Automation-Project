package sania.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.openqa.selenium.support.*;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = ".s-search-results")
	WebElement searchResults;

	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void selectFirstProduct() {
		wait.until(ExpectedConditions.visibilityOf(searchResults));
		List<WebElement> products = searchResults.findElements(By.cssSelector(".s-title-instructions-style"));
		if (!products.isEmpty()) {
			WebElement first = products.get(0);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", first);
			first.click();
		}
	}

	public void switchToNewTab() {
		String original = driver.getWindowHandle();
		for (String win : driver.getWindowHandles()) {
			if (!win.equals(original)) {
				driver.switchTo().window(win);
				break;
			}
		}
	}

	public void addToCart() {
		WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
		addBtn.click();
	}

	public void addProtectionPlan() {
		List<WebElement> protectionOptions = driver.findElements(By.id("attachSiAddCoverage-announce"));
		if (!protectionOptions.isEmpty()) {
			WebElement addProtection = protectionOptions.get(0);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addProtection);
		} else {
			System.out.println("No protection plan offered.");
		}
	}
}
