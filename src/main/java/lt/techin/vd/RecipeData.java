package lt.techin.vd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RecipeData {

    private static String title;
    private static String amount;
    private static String ingredient;
    private static String step;
//    private static String category;
//    private static String cuisine;
    private static String url;
    private static String[] titles = {"Best recipe","Amazing recipe"};
    private static String[] amounts = {"50", "100", "150", "200", "250", "300", "350", "400"};
    private static String[] ingredients = {"butter", "milk", "flour", "sugar","salt", "cheese", "pasta", "chicken"};
    private static String[] steps = {"boil", "cook", "mix", "add", "stir", "bake"};
    private static String[] urls = {"https://www.inspiredtaste.net/wp-content/uploads/2018/10/Homemade-Vegetable-Soup-Recipe-1-1200.jpg", "https://www.tasteofhome.com/wp-content/uploads/2018/01/Cherry-Delight-Dessert_EXPS_TOHcom23_27515_P2_MD_03_22_4b.jpg?fit=700%2C1024", "https://www.themediterraneandish.com/wp-content/uploads/2022/06/chicken-doner-kebab-recipe-9.jpg", "https://wevino.store/cdn/shop/products/image_11bf99a0-a3bd-436a-9984-b6f398c32546.png?v=1710713032&width=900"};


    public static String generateRandomTitle(){
        Random random = new Random();
        return titles[random.nextInt(titles.length)];
    }
    public static String generateRandomAmount(){
        Random random = new Random();
        return amounts[random.nextInt(amounts.length)];
    }
    public static String generateRandomIngredient(){
        Random random = new Random();
        return ingredients[random.nextInt(ingredients.length)];
    }
    public static String generateRandomStep(){
        Random random = new Random();
        return steps[random.nextInt(steps.length)];
    }
    public static String generateRandomUrl(){
        Random random = new Random();
        return urls[random.nextInt(urls.length)];
    }

    public static void generateRecipeData() {
        title = generateRandomTitle();
        amount = generateRandomAmount();
        ingredient = generateRandomIngredient();
        step = generateRandomStep();
        url = generateRandomUrl();

    }
    public static String getTitle() {
        return title;
    }

    public static String getAmount() {
        return amount;
    }

    public static String getIngredient() {
        return ingredient;
    }

    public static String getStep() {
        return step;
    }
    public static String getUrl(){
        return url;
    }
}
