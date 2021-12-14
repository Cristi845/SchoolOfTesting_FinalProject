package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {
    @FindBy(xpath="//input[@id='email_create']")
    private WebElement emailAddressBox;
    @FindBy(id="SubmitCreate")
    private WebElement createAnAccountButton;
    @FindBy(id="id_gender1")
    private WebElement mrRadioButton; // pt test selectez un singur radio button
    @FindBy(id="id_gender2")
    private WebElement mrsRadioButton;
    @FindBy(xpath="//input[@id='customer_firstname']")
    private WebElement firstName;
    @FindBy(xpath="//input[@id='customer_lastname']")
    private WebElement lastName;
    @FindBy(xpath="//input[@id='email']")
    private WebElement emailAddressBox2;
    @FindBy(xpath="//input[@id='passwd']")
    private WebElement password;
    @FindBy(xpath="//select[@id='days']")
    private WebElement dayOfBirthDropdown;
    @FindBy(xpath="//select[@id='months']")
    private WebElement monthOfBirthDropdown;
    @FindBy(xpath="//select[@id='years']")
    private WebElement yearOfBirthDropdown;
    @FindBy(xpath="//input[@id='newsletter']")
    private WebElement newsletterCheckbox;
    @FindBy(xpath="//input[@id='optin']")
    private WebElement receiveSpecialOffersCheckbox;
    @FindBy(xpath="//input[@id='firstname']")
    private WebElement firstName2;
    @FindBy(xpath="//input[@id='lastname']")
    private WebElement lastName2;
    @FindBy(xpath="//input[@id='company']")
    private WebElement company;
    @FindBy(xpath="//input[@id='address1']")
    private WebElement address;
    @FindBy(xpath="//input[@id='address2']")
    private WebElement address2;
    @FindBy(xpath="//input[@id='city']")
    private WebElement city;
    @FindBy(xpath="//select[@id='id_state']")
    private WebElement stateDropdown;
    @FindBy(xpath="//input[@id='postcode']")
    private WebElement zipPostalCode;
    @FindBy(xpath="//select[@id='id_country']")
    private WebElement countryDropdown;
    @FindBy(xpath="//textarea[@id='other']")
    private WebElement additionalInformation;
    @FindBy(xpath="//input[@id='phone']")
    private WebElement homePhone;
    @FindBy(xpath="//input[@id='phone_mobile']")
    private WebElement mobilePhone;
    @FindBy(xpath="//input[@id='alias']")
    private WebElement aliasEmail;
    @FindBy(id="submitAccount")
    public WebElement registerButton;

    private WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completeEmailAddressBoxAndCreateAccount(String email){
        emailAddressBox.sendKeys(email); //sendKeys e metoda de scris in field-uri
        createAnAccountButton.click(); //identific butonul de submit si dau click pe el
    }

    //methods that go into CreateAnAccountTest
    public void clickOnRadioButton(){
        mrRadioButton.click();
    }

    public void fillInPersonalInformation(String firstname, String lastname, String Password)
    {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        password.sendKeys(Password);
    }

    public void selectDayOfBirth(String day) {
        Select dobDropdown = new Select(dayOfBirthDropdown);
        dobDropdown.selectByValue(day);
    }

    public void selectMonthOfBirth(String month) {
        Select dobDropdown = new Select(monthOfBirthDropdown);
        dobDropdown.selectByValue(month);
    }

    public void selectYearOfBirth(String year) {
        Select dobDropdown = new Select(yearOfBirthDropdown);
        dobDropdown.selectByValue(year);
    }

    public void clickOnBoxes(){
        newsletterCheckbox.click();
        receiveSpecialOffersCheckbox.click();
    }

    public void fillInAddress(String firstname, String lastname, String Company, String Address,
                              String Address2, String City){
        firstName2.sendKeys(firstname);
        lastName2.sendKeys(lastname);
        company.sendKeys(Company);
        address.sendKeys(Address);
        address2.sendKeys(Address2);
        city.sendKeys(City);
    }

    public void selectState(String state) {
        Select dobDropdown = new Select(stateDropdown);
        dobDropdown.selectByVisibleText(state);
    }

    public void fillInZipPostalCode(String ZipPostalCode){
        zipPostalCode.sendKeys(ZipPostalCode);
    }

    public void selectCountry(String country) {
        Select dobDropdown = new Select(countryDropdown);
        dobDropdown.selectByVisibleText(country);
    }

    public void fillInAdditionalInfoPhonesAndAliasEmail(String AdditionalInformation, String HomePhone,
                                                        String MobilePhone, String AliasEmail){
        additionalInformation.sendKeys(AdditionalInformation);
        homePhone.sendKeys(HomePhone);
        mobilePhone.sendKeys(MobilePhone);
        aliasEmail.sendKeys(AliasEmail);
    }
    /* ia valoarea din campul respectiv , de retinut
    public String getAliasEmail(){
        return aliasEmail.getText();
    } */

    public String getAliasEmail(){
        return aliasEmail.getAttribute("value"); //my address
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }
}
