package lt.techin.vd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RecipePage extends BasePage {

    public RecipePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "title")
    private WebElement inputTitle;
    @FindBy(id = "ingredients-amount-0")
    private WebElement inputFirstAmount;
    @FindBy(id = "ingredients-name-0")
    private WebElement inputFirstIngridient;
    @FindBy(id = "step-0")
    private WebElement inputFirstStep;
    @FindBy(id = "image")
    private WebElement inputImage;
    @FindBy(css = "[class] [tabindex='0']:nth-child(8)")
    private WebElement clickAddRecipe;
    @FindBy(css = "#mui-component-select-category")
    private WebElement clickCategoriesDropdownList;

    @FindBy(css = ".MuiMenuItem-root:nth-child(3)")
    private WebElement clickCategory;
    @FindBy(css = "#mui-component-select-cuisine")
    private WebElement clickCuisineDropdownList;

    @FindBy(css = ".MuiButtonBase-root:nth-child(16)")
    private WebElement clickCuisine;

    public void inputTitle(String title) {
        inputTitle.sendKeys(title);
    }

    public void inputAmount(String amount) {
        inputFirstAmount.sendKeys(amount);
    }

    public void inputIngredient(String ingredient) {
        inputFirstIngridient.sendKeys(ingredient);
    }

    public void inputStep(String step) {
        inputFirstStep.sendKeys(step);
    }

    public void setClickCategoriesDropdownList() {
        clickCategoriesDropdownList.click();
    }

    public void setClickCategory() {
        ;
        clickCategory.click();
    }

    public void setClickCuisineDropdownList() {
        clickCuisineDropdownList.click();

    }

    public void setClickCuisine() {
        clickCuisine.click();
    }

    public void inputImageUrl(String url) {
        inputImage.sendKeys(url);
    }

    public void clickAddRecipeButton() {
        clickAddRecipe.click();
    }


//    public void selectRandomCategory() {
//        clickCategoriesDropdownList.click();
//        List<WebElement> categoryOptions = driver.findElements(By.cssSelector("ul[role='listbox'] li"));
//        selectRandomOption(categoryOptions);
//
//        WebElement dropdown = driver.findElement(By.cssSelector("div#mui-component-select-category"));
//        dropdown.click();
//        Select select = new Select(dropdown);
//        List<WebElement> options = select.getOptions();
//        int startIndex = 1; // Assuming the first option is a placeholder
//        Random rand = new Random();
//        int randomIndex = rand.nextInt(options.size() - startIndex) + startIndex;
//        options.get(randomIndex).click();


//    }
//
//    public void selectRandomCuisine() throws InterruptedException {
//

//    private void selectRandomOption(List<WebElement> options) {
//        Random random = new Random();
//        int randomIndex = random.nextInt(options.size());
//        options.get(randomIndex).click();
//    }
//    private void selectRandomDropdownOption(By dropdownLocator, By optionsLocator) {
//        // Click the dropdown to reveal options
//        WebElement dropdownElement = driver.findElement(dropdownLocator);
//        dropdownElement.click();
//
//        // Wait for the options to be visible
//        try {
//            Thread.sleep(500); // This is a simple wait, replace with WebDriverWait for better handling
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Get all options
//        List<WebElement> options = driver.findElements(optionsLocator);
//        if (options.size() > 0) {
//            // Select a random option
//            Random rand = new Random();
//            int randomIndex = rand.nextInt(options.size());
//            options.get(randomIndex).click();
//        }
//    }
//
//    public void selectRandomCategory() {
//        // Locate the dropdown and its options
//        By dropdownLocator = By.cssSelector("div#mui-component-select-category");
//        By optionsLocator = By.cssSelector("ul#\\:rb\\: > li");
//        selectRandomDropdownOption(dropdownLocator, optionsLocator);
//    }
//
//    public void selectRandomCuisine() {
//
//        By dropdownLocator = By.cssSelector("div#mui-component-select-cuisine");
//        By optionsLocator = By.cssSelector("ul#\\:rd\\: > li");
//        selectRandomDropdownOption(dropdownLocator, optionsLocator);
//    }
}