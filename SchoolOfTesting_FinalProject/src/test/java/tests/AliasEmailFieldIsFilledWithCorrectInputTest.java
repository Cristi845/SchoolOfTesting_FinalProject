package tests;

import helpers.StringHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.RegistrationPage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AliasEmailFieldIsFilledWithCorrectInputTest {

    WebDriver driver;
    RegistrationPage registrationPage;
    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cstroescu\\OneDrive - ENDAVA\\Desktop\\School of testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSignInButton(); // step 1 -> click on "Sign in" button
        registrationPage = new RegistrationPage(driver);
        String email = StringHelper.generateRandomEmail(); // step 2 -> generate random Email
        registrationPage.completeEmailAddressBoxAndCreateAccount(email); // step 3 -> fill in
        // "Email address" box + click on "Create an account button"
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registrationPage.registerButton));
        registrationPage.clickOnRadioButton();
        registrationPage.fillInPersonalInformation("Johnny","Test",
                "amazing999tomato***");
        registrationPage.selectDayOfBirth("7");
        registrationPage.selectMonthOfBirth("1");
        registrationPage.selectYearOfBirth("1997");
        registrationPage.clickOnBoxes();
        registrationPage.fillInAddress("Johnny","Test","Boeing",
                "Apple street, nr. 9","Orange street, nr. 5","LA");
        registrationPage.selectState("California");
        registrationPage.fillInZipPostalCode("00000"); //000000
        registrationPage.selectCountry("United States");
        registrationPage.fillInAdditionalInfoPhonesAndAliasEmail("My name is " +
                        "Johnny Test and I like to chill","12344321111","43211234111",
                "johnny@testing.com"); // johnny_test@testing.com
    }

    @Test
    public void CreateAnAccount(){
        /*RegistrationPage registrationPage = new RegistrationPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registrationPage.registerButton));
        registrationPage.clickOnRadioButton();
        registrationPage.fillInPersonalInformation("Johnny","Test",
                "amazing999tomato***");
        registrationPage.selectDayOfBirth("7");
        registrationPage.selectMonthOfBirth("1");
        registrationPage.selectYearOfBirth("1997");
        registrationPage.clickOnBoxes();
        registrationPage.fillInAddress("Johnny","Test","Boeing",
                "Apple street, nr. 9","Orange street, nr. 5","LA");
        registrationPage.selectState("California");
        registrationPage.fillInZipPostalCode("00000"); //000000
        registrationPage.selectCountry("United States");
        registrationPage.fillInAdditionalInfoPhonesAndAliasEmail("My name is " +
                "Johnny Test and I like to chill","12344321","43211234",
                "johnny@testing.com"); // johnny_test@testing.com
        //registrationPage.clickOnRegisterButton();*/
    }
    // move common lines in @BeforeEach

    @Test // the bug test
    public void AliasEmailFieldIsFilledWithCorrectInput(){
        assertThat(registrationPage.getAliasEmail(),is("johnny@testing.com"));
    }
}
