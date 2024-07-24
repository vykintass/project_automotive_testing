package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Random;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "name")
    private WebElement inputFirstName;
    @FindBy(id = "lastname")
    private WebElement inputLastName;
    @FindBy(id  = "email")
    private WebElement inputEmail;

    @FindBy ( id = "password")
    private WebElement inputPassword;
    @FindBy ( id = "repeatPassword")
    private WebElement inputRepeatPassword;
    @FindBy( css= "main [tabindex]")
    private WebElement clickSignUpButton;
    @FindBy(id="name-helper-text")
    private WebElement getFirstNameMessage;
    @FindBy(id= "lastname-helper-text")
    private WebElement getLastnameMessage;
    @FindBy(id="email-helper-text")
    private WebElement getEmailMessage;
    @FindBy(id="password-helper-text")
    private WebElement getPasswordMessage;
    @FindBy(id="repeatPassword-helper-text")
    private WebElement getRepeatPasswordMessage;

    public void inputFirstName(String firstname ){
        inputFirstName.sendKeys(firstname);
    }
    public void inputLastName(String lastname ){
        inputLastName.sendKeys(lastname);
    }
    public void inputEmail(String email ){
        inputEmail.sendKeys(email);
    }
    public void inputPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void inputRepeatPassword(String password){
        inputRepeatPassword.sendKeys(password);
    }
    public void clickSignUpButton(){
    clickSignUpButton.click();
    }
    public String getfirstNameMessage(){
      return getFirstNameMessage.getText();
    }
    public String getLastNameMessage(){
        return getLastnameMessage.getText();
    }
    public String getEmailMessage(){
        return getEmailMessage.getText();
    }
    public String getPasswordMessage(){
        return getPasswordMessage.getText();
    }
    public String getRepeatPasswordMessage(){
       return getRepeatPasswordMessage.getText();
    }
}
