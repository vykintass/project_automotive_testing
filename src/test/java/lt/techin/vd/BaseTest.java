package lt.techin.vd;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    RegistrationPage registrationPage;

    LoginPage loginPage;
    AccountPage accountPage;

    ProfilePage profilePage;

    RecipePage recipePage;
    CategoryPage categoryPage;
    CuisinesPage cuisinesPage;
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

    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
