package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginLogoutTests extends BaseTest {

    @Test
    public void createUserAndLogin() throws InterruptedException {

        //creates new user and checks if he is logged in
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);

        registrationPage.clickSignUpButton();

        //checks if confirmation message appears
//        Assertions.assertTrue(homePage.checkWelcomeMessage(), "registration was not successful");

        //checks if newly registered user is logged in
        Assertions.assertEquals(firstName.toLowerCase(), HomePage.logedUserName().toLowerCase());
    }

    @Test
    public void validLoginTest() {
        homePage.clickSignUpHomePage();

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogout();

        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();

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

    @Test
    public void emptyPasswordFieldOnLogin(){
        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword("");
        loginPage.clickLogIn();

        //checks if empty password field error message appears
        Assertions.assertEquals(loginPage.getEmptyPassErrorMessage(), "Please enter your password");
    }

    @Test
    public void invalidEmailAndPassword(){
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

    @Test
    public void logoutFromHomePage(){
        homePage.clickSignUpHomePage();

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogout();

        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();
        homePage.clickLogout();

        //checks if LOGIN button is displayed after successful logout
        Assertions.assertTrue(homePage.isLoginButtonDisplayed());
    }

    @Test
    public void logoutFromUserPage(){
        homePage.clickSignUpHomePage();

        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        homePage.clickLogout();

        homePage.clickLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogIn();
        homePage.clickUserProfile();
        accountPage.clickLogout();

        //checks if LOGIN button is displayed after successful logout
        Assertions.assertTrue(homePage.isLoginButtonDisplayed());
    }

    @Test
    public void adminLogin(){
        homePage.clickLogin();
        loginPage.inputEmail("admin@mail.com");
        loginPage.inputPassword("abc");
        loginPage.clickLogIn();
        homePage.clickUserProfile();

        //checks if user logged as administrator can see distinct to administrator button
        Assertions.assertTrue(accountPage.isCategoriesButtonDisplayed());
    }

    @Test
    public void adminLogout(){
        homePage.clickLogin();
        loginPage.inputEmail("admin@mail.com");
        loginPage.inputPassword("abc");
        loginPage.clickLogIn();
        homePage.clickUserProfile();
        accountPage.clickLogout();

        //checks if user logged as administrator can see distinct to administrator button
        Assertions.assertTrue(homePage.isLoginButtonDisplayed());
    }

    @Test
    public void invalidEmailAdminLogin(){
        homePage.clickLogin();
        loginPage.inputEmail("admin@gmail.com");
        loginPage.inputPassword("123456");
        loginPage.clickLogIn();

        //checks if empty password field error message appears
        Assertions.assertEquals(loginPage.getEmailErrorMessage(), "User with this email does not exists");
    }

    @Test
    public void invalidPasswordAdminLogin(){
        homePage.clickLogin();
        loginPage.inputEmail("admin@mail.com");
        loginPage.inputPassword("abcdefg");
        loginPage.clickLogIn();

        //checks if password field error message appears
        Assertions.assertEquals(loginPage.getWrongPasswordErrorMessage(), "email or password does not match");
    }

    @Test
    public void invalidEmailAndInvalidPasswordAdminLogin(){
        homePage.clickLogin();
        loginPage.inputEmail("admin@gmail.com");
        loginPage.inputPassword("abcdefg");
        loginPage.clickLogIn();

        //checks if email field error message appears
        Assertions.assertEquals(loginPage.getEmailErrorMessage(), "User with this email does not exists");
    }

    @Test
    public void adminInputsOnlyValidEmail(){
        homePage.clickLogin();
        loginPage.inputEmail("admin@mail.com");
        loginPage.inputPassword("");
        loginPage.clickLogIn();

        //checks if empty password field error message appears
        Assertions.assertEquals(loginPage.getEmptyPassErrorMessage(), "Please enter your password");
    }

    @Test
    public void adminInputsOnlyValidPassword(){
        homePage.clickLogin();
        loginPage.inputEmail("");
        loginPage.inputPassword("123456");
        loginPage.clickLogIn();

        //checks if empty email field error message appears
        Assertions.assertEquals(loginPage.getEmptyEmailErrorMessage(), "Please enter your email");
    }

}
