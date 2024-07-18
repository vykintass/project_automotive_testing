package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

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

//    @Test
//    public void loginTest() {
//
//        homePage.clickSignUpHomePage();
//
//        registrationPage.inputFirstName(firstName);
//        registrationPage.inputLastName(lastName);
//        registrationPage.inputEmail(email);
//        registrationPage.inputPassword(password);
//        registrationPage.inputRepeatPassword(password);
//        registrationPage.clickSignUpButton();
//        homePage.clickLogout();
//        homePage.clickLogin();
//
//        loginPage.inputEmail(email);
//        loginPage.inputPassword(password);
//        loginPage.clickLogIn();
//
//        System.out.println(email);
//        System.out.println();
//        Assertions.assertTrue(accountPage.checkWelcomeMessage(), "Log in was not successful");
//
//        //checks if newly registered user is logged in
//       Assertions.assertEquals(firstName.toLowerCase(), HomePage.logedUserName().toLowerCase());
//    }



}
