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
    @FindBy(css = ".MuiButton-colorNeutral.MuiButton-root.MuiButton-sizeMd.MuiButton-variantOutlined.css-s62xdh-JoyButton-root")
    private WebElement clickEditRecipe;
    @FindBy(css= "div[role='status']")
    private WebElement editConfirmation;
    @FindBy(css = "p")
    private WebElement getRecipesText;
    @FindBy(css="div#root > h1:nth-of-type(2)")
    private WebElement checkTextInH1;
    @FindBy(id="link")
    private WebElement clickCategoriesButton;
    public void clickProfile(){
        clickProfile.click();
    }
    public void clickAddRecipe(){
        clickAddRecipe.click();
    }
    public void clickEditRecipe(){
        clickEditRecipe.click();
    }
    public boolean getEditConfirmationMessage(){
       return editConfirmation.isDisplayed();
    }
    public String  getRecipesText(){
        return   getRecipesText.getText();
    }
    public boolean checkTextInH1(){
      return  checkTextInH1.isDisplayed();
    }
    public void clickCategoriesButton(){
        clickCategoriesButton.click();
    }
}
