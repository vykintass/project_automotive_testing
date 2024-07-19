package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="button#login > a")
    private WebElement clickLoginHomePage;
    @FindBy(css="button#signup > a")
    private WebElement clickSignUpHomePage;
    @FindBy(id = "name")
    private WebElement inputName;
    @FindBy (css = ".MuiButtonBase-root:nth-child(5)")
    private WebElement checkWelcomeMessage;
    @FindBy (css ="[href='\\/login']" )
    private WebElement clickLogin;
    @FindBy (css = "button#logout")
    private WebElement logoutButton;
    @FindBy (css = ".css-hyum1k-MuiToolbar-root [href='\\/profile']")
    private static WebElement logedUserLinkToProfile;

    public void clickLoginHomePage() {
        clickLoginHomePage.click();
    }
    public boolean checkLoginButton(){
       return clickLoginHomePage.isDisplayed();
    }
    public void clickSignUpHomePage(){
        clickSignUpHomePage.click();
    }
    public boolean checkWelcomeMessage(){
        return checkWelcomeMessage.isDisplayed();
    }
    public void clickLogin(){
        clickLogin.click();
    }

    public void clickLogout(){
        logoutButton.click();
    }

    public static String logedUserName(){
        return logedUserLinkToProfile.getText().split("\\(")[1].replace(")","");
    }

}
