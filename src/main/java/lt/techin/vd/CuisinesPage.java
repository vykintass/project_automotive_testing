package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CuisinesPage extends BasePage{
    public CuisinesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="h1")
    private WebElement getText;

    public String getWelcomeText(){
        return getText.getText();
    }
}
