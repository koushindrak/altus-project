package com.altus.question3.strategy.designpattern.approach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface ChildReactionStrategy {
    String getReaction();
}

class HappyStrategy implements ChildReactionStrategy {
    public String getReaction() {
        return "Happy Face";
    }
}

class AngryStrategy implements ChildReactionStrategy {
    public String getReaction() {
        return "Angry Face";
    }
}

class NormalStrategy implements ChildReactionStrategy {
    public String getReaction() {
        return "Normal Face";
    }
}

class ErrorStrategy implements ChildReactionStrategy {
    public String getReaction() {
        return "Error Face";
    }
}

class ChildReactionContext {
    private ChildReactionStrategy strategy;

    public void setStrategy(ChildReactionStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy() {
        return strategy.getReaction();
    }
}

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad or Milk To See Child's Face Reaction : ");

        String food = reader.readLine().toLowerCase();

        ChildReactionContext context = new ChildReactionContext();

        context.setStrategy(switch (food) {
            case "ice cream" -> new HappyStrategy();
            case "salad" -> new AngryStrategy();
            case "milk" -> new NormalStrategy();
            default -> new ErrorStrategy();
        });

        System.out.println(context.executeStrategy());
    }

}