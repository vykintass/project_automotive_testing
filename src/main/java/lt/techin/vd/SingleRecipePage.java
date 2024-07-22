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


}
