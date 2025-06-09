package sania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	public AmazonHomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void searchProduct(String productName) {
		wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(productName);
		searchBox.submit();
	}
}
