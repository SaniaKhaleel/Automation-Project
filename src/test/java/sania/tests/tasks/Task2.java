package sania.tests.tasks;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import sania.base.BaseTest;
import sania.pages.AmazonPage;
import sania.utils.ConfigReader;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class Task2 extends BaseTest {

	@Test
	public void amazonPriceTracker() {
		initializeBrowser();

		driver.get(ConfigReader.get("baseUrl"));

		AmazonPage amazon = new AmazonPage(driver);

		amazon.searchBox.sendKeys("iPhone 15");
		amazon.searchButton.click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				org.openqa.selenium.By.cssSelector("div[data-component-type='s-search-result']")));

		String productName = amazon.Link.getText().trim();

		if (!productName.isEmpty()) {
			System.out.println("Selected Product: " + productName);
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(amazon.priceWhole));
			String priceText = amazon.priceWhole.getText();
			System.out.println("Price: ₹" + priceText);

			double price = Double.parseDouble(priceText.replace(",", "").trim());

			double threshold = 60000.0;

			if (price < threshold) {
				System.out.println("Deal Alert: iPhone price is below your threshold!");
				sendEmail("webtesting.sania@gmail.com", "iPhone Deal Alert!",
						"iPhone 15 is now ₹" + priceText + " on Amazon!");
			} else {
				System.out.println("Price is still above threshold.");
			}
		} catch (Exception e) {
			System.out.println("Error while processing price or sending email: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void sendEmail(String to, String subject, String messageText) {

		final String from = "webtesting.sania@gmail.com";
		final String password = "cxltzfxznbeqhqgm";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(messageText);
			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
