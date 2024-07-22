package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="h1")
    private WebElement getText;

    @FindBy (css = ".MuiTypography-gutterBottom.MuiTypography-h5.MuiTypography-root.css-7cysgb-MuiTypography-root")
    private WebElement recipeTitle;

    @FindBy (css = "[href='\\/recipe\\/8']")
    private WebElement viewRecipe;

    public String getWelcomeText(){
        return getText.getText();
    }

    public void clickViewRecipe(){recipeTitle.click();}

    public String getRecipeName(){
        return recipeTitle.getText().split(": ")[1];
    }
}
