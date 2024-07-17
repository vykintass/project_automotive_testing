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
        Assertions.assertTrue(homePage.checkWelcomeMessage(), "registration was not successful");
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
        Assertions.assertTrue(homePage.checkWelcomeMessage(), "registration was not successful");
    }

    @Test
    public void loginTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickSignUpHomePage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
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
        AccountPage accountPage = new AccountPage(driver);
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

//        RecipePage recipePage = PageFactory.initElements(driver, RecipePage.class);

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


        //recipePage.selectRandomCategory();
        //recipePage.selectRandomCuisine();

        recipePage.clickAddRecipeButton();
    }
}


