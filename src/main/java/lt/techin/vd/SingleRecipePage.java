package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingleRecipePage extends BasePage{

    public SingleRecipePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".MuiInputBase-input")
    private WebElement commentField;

    @FindBy (css = "span:nth-of-type(5) > label:nth-of-type(2)")
    private WebElement fiveStars;

    @FindBy (css = "form button")
    private WebElement addCommentButton;

    @FindBy (css = ".flex:last-child > .w-full > .mt-2:nth-child(2)")
    private WebElement userComment;

    @FindBy (xpath = "//div[@id='root']/div[@class='MuiBox-root css-0']//div[@class='MuiBox-root css-k008qs']/li[3]")
    private WebElement showTenComments;

    @FindBy (css = ".Mui-error.MuiFormHelperText-contained.MuiFormHelperText-root.MuiFormHelperText-sizeMedium.css-1wc848c-MuiFormHelperText-root")
    private WebElement emptyCommentMessage;
    @FindBy(css="[class='MuiCardContent-root css-46bh2p-MuiCardContent-root'] button")
    private WebElement clickLikeButton;
    @FindBy(css="[class='MuiCardContent-root css-46bh2p-MuiCardContent-root'] button [focusable]")
    private WebElement checkLikeButton;
    @FindBy(css= "[href='\\/profile\\/1']")
    private WebElement clickCreatorButton;
    @FindBy(css = ".MuiTypography-gutterBottom.MuiTypography-h3.MuiTypography-root.css-1ru1jy8-MuiTypography-root")
    private WebElement checkCreatorName;
    public String ErrorMessageDisplayed(){
       return emptyCommentMessage.getText();
    }

    public void clickShowTenComments(){
        showTenComments.click();
    }

    public String getUserComment(){
        return userComment.getText().split(": ")[1];
    }

    public void clickAddComment(){
        addCommentButton.click();
    }

    public void addComment(String comment){
        commentField.sendKeys(comment);
    }

    public void clickFiveStars(){
        fiveStars.click();
    }
    public void clickLikeButton(){
        clickLikeButton.click();
    }
    public String checkLikeButton(){
       return checkLikeButton.getAttribute("data-testid");
    }
    public void clickCreatorButton(){
        clickCreatorButton.click();
    }
    public boolean checkCreatorName(){
    return    checkCreatorName.isDisplayed();
    }
}
