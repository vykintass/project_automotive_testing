package lt.techin.vd;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = ".MuiButtonBase-root:nth-child(5)")
//    @FindBy (css = ".font-bold.mb-10.mt-10.text-3xl.text-center.underline")
    private WebElement checkWelcomeMessage;
    @FindBy  (css = ".MuiToolbar-gutters.MuiToolbar-regular.MuiToolbar-root.css-hyum1k-MuiToolbar-root > button:nth-of-type(3)")
    private WebElement clickLogout;
    @FindBy(id = "profile")
    private WebElement clickProfile;
    @FindBy (css = "#root > div.flex.justify-around > a:nth-child(1)")
    private WebElement addCategorieButton;

    @FindBy(css = "button:nth-of-type(3) > a")
    private WebElement clickCuisines;
    @FindBy(css = ".css-p7bec2-MuiTypography-root [href='\\/category']")
    private WebElement clickCategory;
    @FindBy(css = ".MuiTypography-h6.MuiTypography-root.css-p7bec2-MuiTypography-root > button:nth-of-type(1) > a")
    private WebElement clickAboutButton;
    public boolean checkWelcomeMessage(){
        return checkWelcomeMessage.isDisplayed();
    }

    public void clickProfile(){
        clickProfile.click();
    }
    public void clickLogout(){
        clickLogout.click();
    }

    public Boolean isCategoriesButtonDisplayed(){
        return addCategorieButton.isDisplayed();}

    public void clickCuisines(){
        clickCuisines.click();
    }
    public void clickCategory(){
        clickCategory.click();
    }
    public void clickAboutButton(){
        clickAboutButton.click();
    }
//    public WebElement getProfileButton() {
//        return driver.findElement(By.cssSelector("button#profile"));
//    }
}
