package lt.techin.vd;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected WebDriver driver;
    protected HomePage homePage;
    protected RegistrationPage registrationPage;

    protected LoginPage loginPage;
    protected AccountPage accountPage;

    protected ProfilePage profilePage;

<<<<<<< HEAD
    protected RecipePage recipePage;

=======
    ProfilePage profilePage;

    RecipePage recipePage;
    CategoryPage categoryPage;
    CuisinesPage cuisinesPage;
>>>>>>> vykintas
    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        profilePage = new ProfilePage(driver);
        recipePage = new RecipePage(driver);
        categoryPage = new CategoryPage(driver);
        cuisinesPage = new CuisinesPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:5173/");

        UserData.generateUserData();
        firstName = UserData.getFirstName();
        lastName = UserData.getLastName();
        email = UserData.getEmail();
        password = UserData.getPassword();


    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
