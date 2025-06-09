package sania.tests.trainingProject;

import sania.pages.*;
import sania.base.BaseTest;
import org.testng.annotations.Test;
import sania.utils.ConfigReader;
import sania.utils.RetryAnalyzer;
public class AmazonTest extends BaseTest {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testOrder() {
		initializeBrowser();
		driver.get(ConfigReader.get("baseUrl"));

		AmazonHomePage home = new AmazonHomePage(driver, wait);
		home.searchProduct("women watch");

		ProductPage product = new ProductPage(driver, wait);
		product.selectFirstProduct();
		product.switchToNewTab();
		product.addToCart();
		product.addProtectionPlan();

		CartPage cart = new CartPage(driver, wait);
		cart.goToCartAndCheckout();
		String email = ConfigReader.get("email");
		String password = ConfigReader.get("password");

		cart.login(email, password);

		cart.secureCheckoutMessage();
		ScreenshotUtil.takeScreenshot(driver, "AfterCheckout");

	}
}
