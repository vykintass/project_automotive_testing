package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css=".css-hyum1k-MuiToolbar-root [href='\\/login']")
    private WebElement clickLoginHomePage;
    @FindBy(css=".MuiToolbar-gutters.MuiToolbar-regular.MuiToolbar-root.css-hyum1k-MuiToolbar-root > button:nth-of-type(2)")
    private WebElement clickSignUpHomePage;
    @FindBy(id = "name")
    private WebElement inputName;
    @FindBy (css = "div#root > .font-bold.text-3xl.underline")
    private WebElement checkWelcomeMessage;
    @FindBy (css ="[href='\\/login']" )
    private WebElement clickLogin;

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

}
