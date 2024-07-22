package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserFeedback extends BaseTest {

    @Test
    public void addComment(){
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
}
