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
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpHomePage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertTrue(homePage.checkWelcomeMessage(), "registration was not succesful");
    }


    @Test
    public void registrationTestFromLoginPage() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();

        HomePage homePage = new HomePage(driver);
        homePage.clickLoginHomePage();
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        loginPage.clickSignUp();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertTrue(homePage.checkWelcomeMessage(), "registration was not succesful");
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

        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpHomePage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();
        AccountPage accountPage = new AccountPage(driver);
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
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpHomePage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        //User login
        LoginPage loginPage = new LoginPage(driver);
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
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickProfile();
        ProfilePage profilePage = new ProfilePage(driver);
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
        RecipePage recipePage = PageFactory.initElements(driver, RecipePage.class);

        //RecipePage recipePage = new RecipePage(driver);
        RecipeData.generateRecipeData();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.inputTitle(RecipeData.getTitle());
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.inputAmount(RecipeData.getAmount());
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.inputIngredient(RecipeData.getIngredient());
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.inputStep(RecipeData.getStep());
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.inputImageUrl(RecipeData.getUrl());
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
//Select from dropwdowns


        recipePage.selectRandomCategory();
        recipePage.selectRandomCuisine();

        recipePage.clickAddRecipeButton();
    }
}


