package sania.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

	WebDriver driver;

	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	public WebElement searchButton;

	@FindBy(xpath = "//h2/parent::a")
	public WebElement Link;

	@FindBy(css = "span.a-price-whole")
	public WebElement priceWhole;
	
	@FindBy(xpath = "//h2/parent::a")
	public List<WebElement> productLinks;

	@FindBy(id = "productTitle")
	public WebElement productTitle;

	@FindBy(css = "span.a-price-whole")
	public WebElement price;

	@FindBy(css = "span.a-icon-alt")
	public WebElement rating;

	@FindBy(id = "acrCustomerReviewText")
	public WebElement reviewCount;

	@FindBy(id = "availability")
	public WebElement availability;
}
