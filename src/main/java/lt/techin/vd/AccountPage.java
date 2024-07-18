package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = ".MuiButtonBase-root:nth-child(5)")
    private WebElement checkWelcomeMessage;
    @FindBy  (css = ".MuiToolbar-gutters.MuiToolbar-regular.MuiToolbar-root.css-hyum1k-MuiToolbar-root > button:nth-of-type(3)")
    private WebElement clickLogout;
    @FindBy(xpath = "/html//div[@id='root']//header/div/button[2]/a[@href='/profile']")
    private WebElement clickProfile;
    public boolean checkWelcomeMessage(){
        return checkWelcomeMessage.isDisplayed();
    }

    public void clickProfile(){
        clickProfile.click();
    }
    public void clickLogout(){
        clickLogout.click();
    }
}
