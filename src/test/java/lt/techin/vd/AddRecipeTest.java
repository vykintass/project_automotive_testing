package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.time.Duration;

public class AddRecipeTest extends BaseTest {

    private final Object monitor = new Object();
    private WebDriverWait wait;

    //TC001a
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

        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe created successfully",toast, "Fail");
    }

    //TC001
    @Test
    public void addNewRecipeCategoryIsNotSelectedTest() throws InterruptedException {

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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();
        Assertions.assertEquals("Category is required", recipePage.getCategeryErrorMessage(), "Fail");

    }

    //TC001b
    @Test
    public void addNewRecipeTitleIsEmptyTest() throws InterruptedException {

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
        RecipeData.generateRecipeData();
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();
        Assertions.assertEquals("Title field is required", recipePage.getTitleErrorMessage(), "Fail");

    }

    //TC001c
    @Test
    public void addNewRecipeIngredientIsEmptyTest() throws InterruptedException {

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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();
        Assertions.assertEquals("Ingredient 1 is required", recipePage.getIngredientErrorMessage(), "Fail");

    }

    //TC001d
    @Test
    public void addNewRecipeAmountIsEmptyTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();
        Assertions.assertEquals("Amount 1 is required", recipePage.getAmountErrorMessage(), "Fail");
    }

    //TC001e
    @Test
    public void addNewRecipeUrlIsEmptyTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.clickAddRecipeButton();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        Assertions.assertTrue(profilePage.checkTextInH1(),"Fail");
        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe created successfully",toast, "Fail");

    }

    //TC001f
    @Test
    public void addNewRecipeCuisineIsEmptyTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();



        Assertions.assertEquals("Cuisine is required", recipePage.getCuisineErrorMessage(), "Fail");

    }

    //TC001g
    @Test
    public void addNewRecipeTitleWithSpacesTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle("              ");
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();
        Assertions.assertEquals("Title cannot be empty or just whitespace", recipePage.getTitleErrorMessage(), "Fail");
    }

    //TC001h
    @Test
    public void removeAdditionalIngredientTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddSecondIngredient();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteSecondIngredient();

    }

    //TC001i
    @Test
    public void removeAdditionalStepTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddSecondStep();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteSecondStep();
        synchronized (monitor) {
            try {
                monitor.wait(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    //TC002
    @Test
    public void editTitleTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();

        recipePage.deleteTitle();
        recipePage.inputTitle("New title");
        recipePage.clickUpdateRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");
//        synchronized (monitor) {
//            try {
//                monitor.wait(100);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//        }

        Assertions.assertEquals("New title", recipePage.getUpdatedCardTitle(), "Fail");
    }
    //TC002a
    @Test
    public void editCategoryTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.clickCategoryDropDownEdit();

        recipePage.clickNewCategory();
        recipePage.clickUpdateRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        Assertions.assertEquals("appetiser", recipePage.getUpdatedCardCategory(), "Fail");

        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");

    }
    //TC002b
    @Test
    public void editIngredientsTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteIngredient();
        recipePage.inputIngredient("New ingredient");
        recipePage.clickUpdateRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");
    }
    //TC002c
    @Test
    public void editIngredientTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteAmount();
        recipePage.inputAmount("New amount");
        recipePage.clickUpdateRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");
    }
    //TC002d
    @Test
    public void editAmountTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteStep();
        recipePage.inputStep("New step");
        recipePage.clickUpdateRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");    }
    //TC002e
    @Test
    public void editUrlTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.deleteUrl();
        recipePage.inputImageUrl("NewImage.img");
        recipePage.clickUpdateRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");    }
    //TC002f
    @Test
    public void editCuisineTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        profilePage.clickEditRecipe();
        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.clickCuisineDropDownEdit();
        recipePage.clickNewCuisine();
        recipePage.clickUpdateRecipe();



        synchronized (monitor) {
            try {
                monitor.wait(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        By toastSelector = recipePage.getToastMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastSelector));
        String toast = toastMessage.getText();
        Assertions.assertEquals("Recipe updated successfully",toast, "Fail");        Assertions.assertEquals("brazilian", recipePage.getUpdatedCardCusine(), "Fail");
    }
    //TC003
    @Test
    public void removeRecipeTest() throws InterruptedException {
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
        RecipeData.generateRecipeData();
        recipePage.inputTitle(RecipeData.getTitle());
        recipePage.inputIngredient(RecipeData.getIngredient());
        recipePage.inputAmount(RecipeData.getAmount());
        recipePage.inputStep(RecipeData.getStep());
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        synchronized (monitor) {
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        recipePage.clickDeleteRecipe();
        recipePage.clickConfirmDelete();
        synchronized (monitor) {
            try {
                monitor.wait(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        Assertions.assertEquals("You have no recipes", profilePage.getRecipesText(), "Fail");
    }
}
