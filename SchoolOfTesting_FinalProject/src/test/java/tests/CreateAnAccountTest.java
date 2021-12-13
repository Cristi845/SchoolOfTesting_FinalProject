package tests;

import helpers.StringHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.RegistrationPage;

public class CreateAnAccountTest {

    WebDriver driver;
    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cstroescu\\OneDrive - ENDAVA\\Desktop\\School of testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSignInButton(); // step 1 -> click on "Sign in" button
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String email = StringHelper.generateRandomEmail(); // step 2 -> generate random Email
        registrationPage.completeEmailAddressBoxAndCreateAccount(email); // step 3 -> fill in
        // "Email address" box + click on "Create an account button"
    }

    @Test
    public void CreateAnAccount(){

    }
}
