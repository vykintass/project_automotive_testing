package lt.techin.vd;

import java.util.Random;

public class RandomComment {


    public static Random random = new Random();
    private final String[] randomComment={
            "Mission accomplished. It's fun, friend.",
            "Such shot, many hero, so fabulous",
            "It's splendid not just clean!",
            "Mission accomplished. It's cool mate",
            "Such magnificent.",
            "I think I'm crying. It's that incredible.",
            "Truly nice shot.",
            "This style blew my mind.",
            "Just sublime :-)",
            "Sublime work you have here."
    };

    public String generateRandomComment(){
        return randomComment[random.nextInt(randomComment.length)];
    }

}
