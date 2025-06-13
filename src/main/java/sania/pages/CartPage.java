package sania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void goToCartAndCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Go to Cart')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("proceedToRetailCheckout"))).click();
	}

	public void login(String email, String password) {
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login")));
		emailInput.sendKeys(email);
		driver.findElement(By.id("continue")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
	}

	public void secureCheckoutMessage() {
		WebElement secureCheckout = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-checkout-title-header-text")));
		secureCheckout.click();

		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a-popover-content-1")));
		System.out.println("Secure Message: " + msg.getText());
	}
}
