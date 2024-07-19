package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class HomeTest extends BaseTest {
    @Test
    public void registrationTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "registration was not successful");
    }


    @Test
    public void registrationTestFromLoginPage() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickLoginHomePage();
        loginPage.clickSignUp();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "registration was not successful");
    }

    @Test
    public void loginTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();
        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "Log in was not successful");
    }

    private final Object monitor = new Object();

    @Test
    public void logoutTest() throws InterruptedException {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        accountPage.clickLogout();
        Assertions.assertTrue(homePage.checkLoginButton(), "Logout was not successful");
    }

    @Test
    public void addOneNewRecipeTest() throws InterruptedException {

        //User registration
        UserData.generateUserData();

        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        //User login
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
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
        profilePage.clickAddRecipe();
        // Fill the recipe form
        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        //RecipePage recipePage = PageFactory.initElements(driver, RecipePage.class);
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        //Select from dropwdowns
        recipePage.clickAddRecipeButton();
    }

    @Test
    public void categoryPageTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        //User login
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
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
        accountPage.clickCategory();
        Assertions.assertEquals("ALL CATEGORIES", categoryPage.getWelcomeText(), "Not equal");
    }
    @Test
    public void cuisinesPageTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        //User login
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
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
        accountPage.clickCuisines();
        Assertions.assertEquals("ALL CUISINES", categoryPage.getWelcomeText(), "Not equal");
    }
    @Test
    public void aboutButtonTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        //User login
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
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
        //Go to About page from Cuisines
        accountPage.clickCuisines();
        accountPage.clickAboutButton();
        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "Not successful");
        //Go to About page from category
        accountPage.clickCategory();
        accountPage.clickAboutButton();
        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "Not successful");

    }
    @Test
    public void addRecipeAddIngredientAddStepDeleteIngredientDeleteStep(){

        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        //User login
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
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
        profilePage.clickAddRecipe();
        // Fill the recipe form
        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        //Select from dropwdowns
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        RecipeData.generateRecipeData();
        recipePage.clickAddSecondIngredient();
        recipePage.inputSecondIngredient(RecipeData.getIngredient());
        recipePage.inputSecondAmount(RecipeData.getAmount());
        recipePage.clickAddSecondStep();
        recipePage.inputSecondStep(RecipeData.getStep());
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteSecondIngredient();
        recipePage.deleteSecondStep();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.clickAddRecipeButton();

    }
}


