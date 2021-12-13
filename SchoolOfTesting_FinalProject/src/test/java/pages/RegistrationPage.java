package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    @FindBy(xpath="//input[@id='email_create']")
    private WebElement emailAddressBox;
    @FindBy(id="SubmitCreate")
    private WebElement createAnAccountButton;

    private WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completeEmailAddressBoxAndCreateAccount(String email){
        emailAddressBox.sendKeys(email); //sendKeys e metoda de scris in field-uri
        createAnAccountButton.click(); //identific butonul de submit si dau click pe el
    }

}
