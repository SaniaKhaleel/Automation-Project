**Amazon Automation Project:**

This project showcases automation of various user flows on the Amazon website using Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern.



**Technologies Used:**

 Java,
 Selenium WebDriver,
 TestNG,
 Maven,
 Jakarta Mail API (for email notifications).


**Project Structure:**

sania.tests

 Task1.java // get() vs navigate().to() + back/forward()
 
 Task2.java // Amazon price tracker + email alert
 
 Task3.java // Real-time filter automation with time 
 
 trainingProject:
 
 AmazonTest.java // Full flow: Search, add to cart, login, and capture screenshot.



**Tasks Overview:**

**Task 1** – Demonstrates the difference between driver.get() and driver.navigate().to().

  Uses navigate().back() and navigate().forward() to simulate browser history.
  
  Asserts page titles of Google and Amazon.
  
  Focus: Browser control and navigation.




**Task 2** – Price Tracker with Email Notification

 Searches for iPhone 15.
 
 Checks the price and compares with a set threshold (₹60,000).
 
 If price is below the threshold, sends an email alert using JavaMail API.
 
 Focus: Price tracking logic + Email automation.



 **Task 3 **– Filtered Product Click (3PM to 6PM Only)

 Runs only between 3:00 PM and 6:00 PM.
 
 Searches for Hair Oil.
 
 Skips products starting with A, B, C, or D.
 
 Clicks and prints key product info like title, price, rating, reviews, availability.
 
 Focus: Time-based test run + product filtering logic.



** Training Project** – Add to Cart + Checkout Flow

 Searches for Women Watch.
 
 Selects first product, adds it to the cart, and continues checkout.
 
 Performs login using credentials from config.properties.
 
 Takes a screenshot after checkout.
 
 Includes retry logic for flaky tests.
 
 Focus: Realistic POM implementation with full flow + screenshot + retries.
 


  **Sample Screenshot**

Stored in the /screenshots/ folder with name AfterCheckout.png.



 **Learning Highlights**

 Efficient use of waits (WebDriverWait).
 
 Handling dynamic product filters.
 
 Browser history navigation.
 
 Jakarta Mail integration.
 
 TestNG annotations and retry mechanism.
 
 Real-time test control based on system time.
 


**Credentials Handling (Secure Practice)**

Passwords should be handled securely:

Use environment variables (System.getenv("EMAIL_PASSWORD")).

Avoid hardcoding sensitive data (only used here for training purposes).



**How to Run**

Clone this repo.

Update config.properties with your email, password.


**Author**
Sania Khaleel.

🔗 LinkedIn (https://www.linkedin.com/in/sania-khaleel).



