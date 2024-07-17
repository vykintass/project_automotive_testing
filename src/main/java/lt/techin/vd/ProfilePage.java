package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css= ".css-hyum1k-MuiToolbar-root [href='\\/profile']")
    private WebElement clickProfile;
    @FindBy (css = "a:nth-of-type(2) > button")
    private WebElement clickAddRecipe;

    public void clickProfile(){
        clickProfile.click();
    }
    public void clickAddRecipe(){
        clickAddRecipe.click();
    }

}
