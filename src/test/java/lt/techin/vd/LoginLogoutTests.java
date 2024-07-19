package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginLogoutTests extends BaseTest {

    @Test
    public void createUserAndLogin(){

        //creates new user and checks if he is logged in
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();

        //checks if confirmation message appears
        Assertions.assertTrue(homePage.checkWelcomeMessage(), "registration was not successful");

        //checks if newly registered user is logged in
        Assertions.assertEquals(firstName.toLowerCase(), HomePage.logedUserName().toLowerCase());
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        homePage.clickSignUpHomePage();

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Thread.sleep(3000);
        homePage.clickLogout();

        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();
        Thread.sleep(3000);

        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "Log in was not successful");

        //checks if newly registered user is logged in
//       Assertions.assertEquals(firstName.toLowerCase(), HomePage.logedUserName().toLowerCase());
    }

    @Test
    public void loginTestInvalidEmail(){
        homePage.clickSignUpHomePage();

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogout();

        homePage.clickLogin();
        loginPage.inputEmail("abc" + email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();

        //checks if invalid email error message appears
        Assertions.assertEquals(loginPage.getEmailErrorMessage(), "User with this email does not exists");
    }

    @Test
    public void emptyEmailFieldOnLogin(){
        homePage.clickLogin();
        loginPage.inputEmail("");
        loginPage.inputPassword(password);
        loginPage.clickLogIn();

        //checks if empty email field error message appears
        Assertions.assertEquals(loginPage.getEmptyEmailErrorMessage(), "Please enter your email");
    }

    @Test void emptyPasswordFieldOnLogin(){
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword("");
        loginPage.clickLogIn();

        //checks if empty password field error message appears
        Assertions.assertEquals(loginPage.getEmptyPassErrorMessage(), "Please enter your password");
    }

    @Test void invalidEmailAndPassword(){
        homePage.clickSignUpHomePage();

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogout();

        homePage.clickLogin();
        loginPage.inputEmail("abc" + email);
        loginPage.inputPassword("123" + password);
        loginPage.clickLogIn();

        //checks if invalid email error message appears
        Assertions.assertEquals(loginPage.getEmailErrorMessage(), "User with this email does not exists");
    }







}
