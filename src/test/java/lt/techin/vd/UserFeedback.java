package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserFeedback extends BaseTest {

    @Test
    public void addValidComment(){
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();

        accountPage.clickProfile();

        profilePage.clickAddRecipe();

        //adds new recipe if there's no recipes in "CATEGORY"
        recipePage.inputTitle(recipeTitle);
        recipePage.inputAmount(amount);
        recipePage.inputIngredient(ingredient);
        recipePage.inputStep(step);
        //select from dropdown menu
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        accountPage.clickCategory();
        categoryPage.clickViewRecipe();

        recipe.clickShowTenComments();
        recipe.addComment(randomComment);
        System.out.println(randomComment);
        recipe.clickFiveStars();
        recipe.clickAddComment();

        Assertions.assertEquals(randomComment, recipe.getUserComment());
    }

    @Test
    public void addEmptyComment(){
        //create new user
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();

        accountPage.clickProfile();

        profilePage.clickAddRecipe();

        //adds new recipe if there's no recipes in "CATEGORY"
        recipePage.inputTitle(recipeTitle);
        recipePage.inputAmount(amount);
        recipePage.inputIngredient(ingredient);
        recipePage.inputStep(step);

        //select from dropdown menu
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        accountPage.clickCategory();
        categoryPage.clickViewRecipe();

        recipe.clickShowTenComments();
        recipe.addComment("");
        recipe.clickFiveStars();
        recipe.clickAddComment();

        Assertions.assertEquals(recipe.ErrorMessageDisplayed(), "Comment is required");
    }

    @Test
    public void commentOutsideOfBoundaries(){
        //create new user
        homePage.clickSignUpHomePage();
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(password);
        registrationPage.clickSignUpButton();

        accountPage.clickProfile();

        profilePage.clickAddRecipe();

        //adds new recipe if there's no recipes in "CATEGORY"
        recipePage.inputTitle(recipeTitle);
        recipePage.inputAmount(amount);
        recipePage.inputIngredient(ingredient);
        recipePage.inputStep(step);

        //select from dropdown menu
        recipePage.setClickCategoriesDropdownList();
        recipePage.setClickCategory();
        recipePage.setClickCuisineDropdownList();
        recipePage.setClickCuisine();
        recipePage.inputImageUrl(RecipeData.getUrl());
        recipePage.clickAddRecipeButton();

        accountPage.clickCategory();
        categoryPage.clickViewRecipe();

        String longComment = "68G9qXtLmJhXLcUX06GDE4z32pqRzrW6qJ3q7eDnQyJ2nmdwxeN1CMXL5QEFbZPPAHM5C1BV6j8CQmND9HA" +
                "hhik2x1GDg2AcHQhhTLfK0MLatE2QzGLxBHSSLY0PiAkm1pyfXXkJ41f8QpfktZiMvJDhu0p88KYx1CLWNu5g1YJWzuQeAnG" +
                "1aHQWvnFetq63qGXbjHjti6aRgaEMb3V9EhN4Pvf7qUEKx22WiNDuRbqqBr03QYJ6amqduPVigqFVbewd86z97xgvVu68xR7" +
                "u0tzbFFJ1F2UrFEfjR2bQ7jK3z25rMzALKNktwAF8Mk8GVrwdG5CZ6W7LHKhz4ebA28cPyyRqWg9adHuYZU1gb1emkkMC0hm" +
                "09kmW4b8nyU2FeuMzWBcmy1xR9c8brRUK3QMSHE1SE6HyGmieQbYvj9LY6wi9DRHKNJXBZaZbqJiixQrzqkP5Scy6npgzWKi" +
                "YAvX46uEHHLVf2pgNBfivZvtZAjd5A2rVdJcLejKXWRSr7NXYMC7JG0x1WCkJZLLkGHQJ6q0nXV614RnkUSWMeG9cXgd9HAE" +
                "YDcMDNvD9CpU2rqyjtUpC7gBWwqZGd7SrDnG2WXbCixvGNFFVHAmFyUXjpFbyxGuPdPZcphx";
        recipe.clickShowTenComments();
        recipe.addComment(longComment);
        recipe.clickFiveStars();
        recipe.clickAddComment();

        Assertions.assertEquals(recipe.ErrorMessageDisplayed(), "Comment cannot exceed 500 characters");
    }



}
