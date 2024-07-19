package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest{
    @Test
    public void registrationWithValidCredentialsTest() {
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        //simple registration with valid credentials
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
    public void registrationWithEmptyFirstNameTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName("");
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter your name",registrationPage.getfirstNameMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithTooLongFirstNameTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName("Alexandriannaelizabethvictoriaameliaangelinajeniferrosemariechristinaophiliarosalineclarabellavendela");
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("First Name must be less than 100 characters",registrationPage.getfirstNameMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithInvalidFirstNameTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName("@./'[]");
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter valid name format",registrationPage.getfirstNameMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithInvalidLastNameTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName("@./'[]");
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter valid name format",registrationPage.getLastNameMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithTooLongLastNameTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputLastName("Alexandriannaelizabethvictoriaameliaangelinajeniferrosemariechristinaophiliarosalineclarabellavendela");
        registrationPage.inputFirstName(firstName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Last Name must be less than 100 characters",registrationPage.getLastNameMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithEmptyLastNameTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName("");
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter your Last Name",registrationPage.getLastNameMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithEmptyEmailTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail("");
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter your email",registrationPage.getEmailMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithNoEtaTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail("kxk.gmaill.com");
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Invalid email address format",registrationPage.getEmailMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithNoDotTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail("kxk@com");
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Invalid email address format",registrationPage.getEmailMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithNoDomenTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail("kxk@a");
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Invalid email address format",registrationPage.getEmailMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithUsedEmailTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail("batonas@gmail.com");
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Such email The email address has already been created",registrationPage.getEmailMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithEmptyPasswordTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("");
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter your password",registrationPage.getPasswordMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithTooLongPasswordTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("Alexandriannaelizabethvictoriaameliaangelinajeniferrosemariechristinaophiliarosalineclarabellavendela");
        registrationPage.inputRepeatPassword("Alexandriannaelizabethvictoriaameliaangelinajeniferrosemariechristinaophiliarosalineclarabellavendela");
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please confirm your password",registrationPage.getPasswordMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithTooShortPasswordTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("Aa1.");
        registrationPage.inputRepeatPassword("Aa1.");
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please confirm your password",registrationPage.getPasswordMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithIncorrectPasswordFormTest(){
        UserData.generateUserData();
        String firstName = UserData.getFirstName();
        String lastName = UserData.getLastName();
        String email = UserData.getEmail();
        String password = UserData.getPassword();
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("batas");
        registrationPage.inputRepeatPassword("batas");
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please confirm your password",registrationPage.getPasswordMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithEmptyRepeatPasswordTest(){
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
        registrationPage.inputRepeatPassword("");
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please confirm your password",registrationPage.getRepeatPasswordMessage(), "registration was sccessful");
    }
    @Test
    public void registrationWithMismatchingRepeatPasswordTest(){
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
        registrationPage.inputRepeatPassword("aaa");
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("The passwords do not match",registrationPage.getRepeatPasswordMessage(), "registration was sccessful");
    }
    @Test
    public void registrationAllEmptyFieldsTest(){
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName("");
        registrationPage.inputLastName("");
        registrationPage.inputEmail("");
        registrationPage.inputPassword("");
        registrationPage.inputRepeatPassword("");
        registrationPage.clickSignUpButton();
        Assertions.assertEquals("Please enter your name", registrationPage.getfirstNameMessage(), "incorrect");
        Assertions.assertEquals("Please enter your Last Name", registrationPage.getLastNameMessage(), "incorrect");
        Assertions.assertEquals("Please enter your email", registrationPage.getEmailMessage(), "incorrect");
        Assertions.assertEquals("Please enter your password", registrationPage.getPasswordMessage());
        Assertions.assertEquals("Please confirm your password", registrationPage.getRepeatPasswordMessage());
    }


}
