package tests;

import helpers.StringHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.RegistrationPage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidationOfElementsTest {

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
    }

    @Test
    public void ValidationOfElements(){
        assertThat(registrationPage.getcreateAnAccountText(),is("CREATE AN ACCOUNT"));
        assertThat(registrationPage.getyourPersonalInfoText(),is("YOUR PERSONAL INFORMATION"));
        assertThat(registrationPage.gettitleText(),is("Title"));
        assertThat(registrationPage.getfirstNameText(),is("First name *"));
        assertThat(registrationPage.getlastNameText(),is("Last name *"));
        assertThat(registrationPage.getemailText(),is("Email *"));
        assertThat(registrationPage.getpasswordText(),is("Password *"));
        assertThat(registrationPage.getdateOfBirthText(),is("Date of Birth"));
        assertThat(registrationPage.getsignUpForOurNewsletterText(),is("Sign up for our newsletter!"));
        assertThat(registrationPage.getreceiveSpecialOffersText(),is("Receive special offers from our partners!"));
        assertThat(registrationPage.getyourAddressText(),is("YOUR ADDRESS"));
        assertThat(registrationPage.getcompanyText(),is("Company"));
        assertThat(registrationPage.getaddressText(),is("Address *"));
        assertThat(registrationPage.getaddressText2(),is("Address (Line 2)"));
        assertThat(registrationPage.getcityText(),is("City *"));
        assertThat(registrationPage.getstateText(),is("State *"));
        assertThat(registrationPage.getzipPostalCodeText(),is("Zip/Postal Code *"));
        assertThat(registrationPage.getcountryText(),is("Country *"));
        assertThat(registrationPage.getadditionalInformationText(),is("Additional information"));
        assertThat(registrationPage.gethomePhoneText(),is("Home phone"));
        assertThat(registrationPage.getmobilePhoneText(),is("Mobile phone *"));
        assertThat(registrationPage.getassignAnAddressAliasText(),is("Assign an address alias for future reference. *"));
        assertThat(registrationPage.getregisterText(),is("Register"));
    }
}
