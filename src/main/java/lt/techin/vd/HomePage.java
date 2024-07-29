package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="button#login")
    private WebElement clickLoginHomePage;
    @FindBy(css="button#signup")
    private WebElement clickSignUpHomePage;
    @FindBy(css = "#name")
    private WebElement inputName;
    @FindBy (css = ".MuiButtonBase-root:nth-child(5)")
    private WebElement checkWelcomeMessage;
<<<<<<< HEAD
    @FindBy (css ="button#buttonlogin" )
=======
    @FindBy (css ="#login" )
>>>>>>> 3c146cb68a00f4ab11f25052fe99466e6379b2b5
    private WebElement clickLogin;
    @FindBy (css = "button#logout")
    private WebElement logoutButton;
    @FindBy (css = "button#profile")
    private static WebElement loggedUserProfileLink;


    public void clickLoginHomePage() {
        clickLoginHomePage.click();
    }
    public boolean checkLoginButton(){
       return clickLoginHomePage.isDisplayed();
    }
    public void clickSignUpHomePage(){
        clickSignUpHomePage.click();
    }

//    public boolean checkWelcomeMessage(){
//        return checkWelcomeMessage.isDisplayed();
//    }

    public void clickLogin(){
        clickLogin.click();
    }

    public void clickLogout(){
        logoutButton.click();
    }

    public Boolean isLoginButtonDisplayed(){
       return clickLoginHomePage.isDisplayed();
    }

    public void clickUserProfile(){
        loggedUserProfileLink.click();
    }

    public String checkWelcomeMessage(){
        return checkWelcomeMessage.getText();
    }

    public static String loggedUserName(){
        return loggedUserProfileLink.getText().split("\\(")[1].replace(")","");
    }

}
