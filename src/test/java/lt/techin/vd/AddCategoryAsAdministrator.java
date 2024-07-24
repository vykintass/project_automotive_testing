package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCategoryAsAdministrator extends BaseTest{
    private final Object monitor = new Object();
    //TC001a
    @Test
    public void addNewCategory(){

        homePage.clickLogin();
        loginPage.inputEmail("batonas@gmail.com");
        loginPage.inputPassword("abc");
        loginPage.clickLogIn();
        //Wait to make profile button clickable
//        By profileButtonSelector = By.cssSelector(".css-hyum1k-MuiToolbar-root [href='\\/profile']");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        try {
//            // Wait until the profile button is visible
//            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonSelector));
//
//            // Now you can click the button or perform other actions
//            profileButton.click();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        accountPage.clickProfile();
        profilePage.clickCategoriesButton();
        categoryPage.clickDeleteCategory();
        categoryPage.clickConfirmDelete();
        categoryPage.inputCategory("Snacks");
        categoryPage.clickSubmitCategory();

        By toastSelector = By.cssSelector("div:nth-of-type(5) > .go4109123758  div[role='status']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("New category created \uD83D\uDD25",toast, "Fail");
        Assertions.assertTrue(categoryPage.checkNewCategory(),"Fail");

    }
    //TC001b
    @Test
    public void addTheSameCategory(){

        homePage.clickLogin();
        loginPage.inputEmail("batonas@gmail.com");
        loginPage.inputPassword("abc");
        loginPage.clickLogIn();
        //Wait to make profile button clickable

        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
//        By profileButtonSelector = By.cssSelector(".css-hyum1k-MuiToolbar-root [href='\\/profile']");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        try {
//            // Wait until the profile button is visible
//            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonSelector));
//
//            // Now you can click the button or perform other actions
//            profileButton.click();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        accountPage.clickProfile();
        profilePage.clickCategoriesButton();
//        categoryPage.clickDeleteCategory();
//        categoryPage.clickConfirmDelete();
        categoryPage.inputCategory("Snacks");
        categoryPage.clickSubmitCategory();
        categoryPage.deleteCategoryField();
        categoryPage.inputCategory("Snacks");
        categoryPage.clickSubmitCategory();

        By toastSelector = By.cssSelector("div:nth-of-type(5) > .go4109123758  div[role='status']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();

        Assertions.assertEquals("Category: Snacks already created",toast, "Fail");
    }
    //TC002
    @Test
    public void deleteCategory(){

        homePage.clickLogin();
        loginPage.inputEmail("batonas@gmail.com");
        loginPage.inputPassword("abc");
        loginPage.clickLogIn();
        //Wait to make profile button clickable

        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        accountPage.clickProfile();
        profilePage.clickCategoriesButton();
//        categoryPage.clickDeleteCategory();
//        categoryPage.clickConfirmDelete();
        categoryPage.inputCategory("Snacks");
        categoryPage.clickSubmitCategory();
        categoryPage.clickDeleteCategory();
        categoryPage.clickConfirmDelete();

        By toastSelector = By.cssSelector("div:nth-of-type(5) > .go4109123758  div[role='status']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();

        Assertions.assertEquals("Category Snacks was deleted!",toast, "Fail");
     //   Assertions.assertFalse(categoryPage.checkNewCategory(), "Fail");
    }
    //TC002a
    @Test
    public void pressCancelWhenDeletingCategory(){

        homePage.clickLogin();
        loginPage.inputEmail("batonas@gmail.com");
        loginPage.inputPassword("abc");
        loginPage.clickLogIn();
        //Wait to make profile button clickable

        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        accountPage.clickProfile();
        profilePage.clickCategoriesButton();
//        categoryPage.clickDeleteCategory();
//        categoryPage.clickConfirmDelete();
        categoryPage.inputCategory("Snacks");
        categoryPage.clickSubmitCategory();
        categoryPage.clickDeleteCategory();
        categoryPage.clickCancelButton();



        Assertions.assertTrue(categoryPage.checkNewCategory(), "Fail");
    }
}
