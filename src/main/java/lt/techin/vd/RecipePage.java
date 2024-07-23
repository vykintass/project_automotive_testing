package lt.techin.vd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

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
    @FindBy(css = ".MuiMenuItem-root:nth-child(4)")
    private WebElement clickNewCategory;
    @FindBy(css = "#mui-component-select-cuisine")
    private WebElement clickCuisineDropdownList;

    @FindBy(css = ".MuiButtonBase-root:nth-child(16)")
    private WebElement clickCuisine;
    @FindBy(css = ".MuiButtonBase-root:nth-child(17)")
    private WebElement clickNewCuisine;
    @FindBy(css = ".MuiBox-root.css-164r41r > button:nth-of-type(1)")
    private WebElement clickAddIngridient;
    @FindBy(css = ".MuiBox-root.css-164r41r > button:nth-of-type(2)")
    private WebElement clickAddStep;
    @FindBy(css= "div:nth-of-type(3) > .MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.css-78trlr-MuiButtonBase-root-MuiIconButton-root")
    private WebElement deleteSecondIngridient;
    @FindBy(css = ".MuiBox-root:nth-child(5) path")
    private WebElement deleteSecondStep;
    @FindBy(css="input[name='ingredients.1.amount']")
    private WebElement inputSecondAmount;
    @FindBy(css="input[name='ingredients.1.ingredient']")
    private WebElement inputSecondIngredient;
    @FindBy(css = "input[name='steps.1']")
    private WebElement inputSecondStep;
    @FindBy(css = ".Mui-error.MuiFormHelperText-contained.MuiFormHelperText-root.MuiFormHelperText-sizeMedium.css-1wc848c-MuiFormHelperText-root")
    private WebElement getCategoryErrorMessage;
    @FindBy(css = "p#title-helper-text")
    private WebElement getTitleErrorMessage;
    @FindBy(css = "p#ingredients-amount-0-helper-text")
    private WebElement getAmountErrorMessage;
    @FindBy(css = "p#ingredients-name-0-helper-text")
    private WebElement getIngredientErrorMessage;
    @FindBy(css = "")
    private WebElement getStepsErrorMessage;
    @FindBy(css = "[class] .css-q8hpuo-MuiFormControl-root:nth-of-type(2) p")
    private WebElement getCuisineErrorMessage;
    @FindBy(css = "p#image-helper-text")
    private WebElement getUrlErrorMessage;
    @FindBy(css = "[class] [tabindex='0']:nth-child(8)")
    private WebElement clickUpdateRecipe;
    @FindBy(css = ".flex.flex-wrap.gap-10.justify-center > div:nth-of-type(1) .break-all.card-title")
    private WebElement getUpdatedCardTitle;
    @FindBy(css = "div#mui-component-select-category")
    private WebElement clickCategoryDropDownEdit;
    @FindBy(css = "div#mui-component-select-cuisine")
    private WebElement clickCuisineDropDownEdit;
    @FindBy(css = "p")
    private WebElement getUpdatedCardCategory;
    @FindBy(css = ".card-body .card-title:nth-of-type(2)")
    private WebElement getUpdatedCardCuisine;
    @FindBy(css = ".btn.btn-error.btn-outline")
    private  WebElement clickDeleteRecipe;
    @FindBy(css = "[class='mt-4 flex justify-center space-x-2'] .btn-error")
    private WebElement clickConfirmDelete;
//        @FindBy(css="div:nth-of-type(54) > .go4109123758  div[role='status']")
//        private WebElement getToastMessage ;div:nth-of-type(62) > .go4109123758 > .go2072408551
        public By getToastMessage(){
            return By.cssSelector(".go4109123758 > .go2072408551");
        }

    public void inputTitle(String title) {
        inputTitle.sendKeys(title);
    }
    public void deleteTitle(){
        inputTitle.clear();
    }
    public String getTitle(){
       return inputTitle.getText();
    }
    public void clickUpdateRecipe(){
        clickUpdateRecipe.click();
    }
    public void inputAmount(String amount) {
        inputFirstAmount.sendKeys(amount);
    }
    public void deleteAmount(){
        inputFirstAmount.clear();
    }
    public void inputIngredient(String ingredient) {
        inputFirstIngridient.sendKeys(ingredient);
    }
    public void deleteIngredient(){
        inputFirstIngridient.clear();
    }
    public void inputStep(String step) {
        inputFirstStep.sendKeys(step);
    }
    public void deleteStep(){
        inputFirstStep.clear();
    }
    public void setClickCategoriesDropdownList() {
        clickCategoriesDropdownList.click();
    }

    public void setClickCategory() {
        clickCategory.click();
    }
    public void clickCategoryDropDownEdit(){
        clickCategoryDropDownEdit.click();
    }
    public void clickCuisineDropDownEdit(){
        clickCuisineDropDownEdit.click();
    }
public void clickNewCategory(){
        clickNewCategory.click();
}
    public void setClickCuisineDropdownList() {
        clickCuisineDropDownEdit.click();

    }
    public void clickNewCuisine(){
        clickNewCuisine.click();
    }
    public void setClickCuisine() {
        clickCuisine.click();
    }

    public void inputImageUrl(String url) {
        inputImage.sendKeys(url);
    }
    public void deleteUrl(){
        inputImage.clear();
    }
    public void clickAddSecondIngredient(){
        clickAddIngridient.click();
    }
    public void inputSecondIngredient( String ingredient){
        inputSecondIngredient.sendKeys(ingredient);

    }
    public void inputSecondAmount(String amount){
        inputSecondAmount.sendKeys(amount);
    }
    public boolean isSecondIngredientPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickAddSecondStep(){
        clickAddStep.click();
    }
    public void inputSecondStep(String step){
        inputSecondStep.sendKeys(step);
    }

    public void deleteSecondIngredient(){
        deleteSecondIngridient.click();
    }
    public void deleteSecondStep(){
        deleteSecondStep.click();
    }
    public void clickAddRecipeButton() {
        clickAddRecipe.click();
    }
    public String getCategeryErrorMessage(){
        return getCategoryErrorMessage.getText();
    }
    public String getTitleErrorMessage(){
        return getTitleErrorMessage.getText();
    }
    public String getAmountErrorMessage(){
        return getAmountErrorMessage.getText();
    }
    public String getIngredientErrorMessage(){
        return getIngredientErrorMessage.getText();
    }
    public String getCuisineErrorMessage(){
        return getCuisineErrorMessage.getText();
    }
    public String getStepsErrorMessage(){
        return getStepsErrorMessage.getText();
    }
    public String getUrlErrorMessage(){
        return getUrlErrorMessage.getText();
    }
    public String getUpdatedCardTitle(){
        String fullText = getUpdatedCardTitle.getText();
        String actualTitle = fullText.replace("Name: ", "").trim();
        return actualTitle;
    }
    public String getUpdatedCardCusine(){
        String fullText = getUpdatedCardCuisine.getText();
        String actualCuisine = fullText.replace("Cusine: ", "").trim();
        return actualCuisine;
    }
    public String getUpdatedCardCategory(){
        String fullText = getUpdatedCardCategory.getText();
        String actualCategory = fullText.replace("Category: ", "").trim();
        return actualCategory;
    }
    public void clickDeleteRecipe(){
        clickDeleteRecipe.click();
    }
    public void clickConfirmDelete(){
        clickConfirmDelete.click();
    }

}