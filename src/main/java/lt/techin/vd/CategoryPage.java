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
    @FindBy(id="category")
    private WebElement inputCategory;
    @FindBy(css="li:nth-of-type(5) > div > .bg-slate-500.border.p-2.rounded-lg")
    private WebElement clickDeleteCategory;
    @FindBy(css=".bg-red-500.px-4.py-2.rounded.text-white")
    private WebElement clickConfirmDelete;
    @FindBy(css = ".bg-gray-300.px-4.py-2.rounded")
    private WebElement clickCancelButton;
    @FindBy(id="buttonnewcat")
    private WebElement clickSubmitCategory;
    public String getWelcomeText(){
        return getText.getText();
    }
    public void inputCategory(String category){
        inputCategory.sendKeys(category);
    }
    public void clickDeleteCategory(){
        clickDeleteCategory.click();
    }
    public void clickConfirmDelete(){
        clickConfirmDelete.click();
    }
    public void clickCancelButton(){
        clickCancelButton.click();
    }
    public void clickSubmitCategory(){
        clickSubmitCategory.click();
    }
    public boolean checkNewCategory(){
        return clickDeleteCategory.isDisplayed();
    }
    public void deleteCategoryField(){
        inputCategory.clear();
    }
}
