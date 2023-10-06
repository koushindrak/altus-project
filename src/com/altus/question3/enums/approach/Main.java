package com.altus.question3.enums.approach;

import java.io.*;

/**
 * Enum contains different types of food and associated child's facial expressions.
 */
enum Food {
    ICE_CREAM("Happy Face"),
    SALAD("Angry Face"),
    MILK("Normal Face");

    private final String face;

    /**
     * @param face A string representing the child's face expression.
     */
    Food(String face) {
        this.face = face;
    }

    /**
     * Retrieves the face expression associated with the food type.
     *
     * @return A string representing the child's face expression.
     */
    public String getFace() {
        return face;
    }

    /**
     * Returns face expression based on the provided food name.*
     * @param name A string representing the name of the food.
     * @return A string representing the child's face expression.
     */
    public static String getFaceByFoodName(String name) {
        return switch (name.toLowerCase()) {
            case "ice cream" -> ICE_CREAM.getFace();
            case "salad" -> SALAD.getFace();
            case "milk" -> MILK.getFace();
            default -> "Error Face";
        };
    }
}


public class Main {
    /**
     * Interacts with the user, asking for the food type, and displays the corresponding child's face expression.
     *
     * @param args Command-line arguments passed during the application start. Not used in this application.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Feed Child With Ice Cream, Salad, or Milk To See Child's Face Reaction : ");

        // Reading user input and storing it in 'food'
        var food = reader.readLine();

        // Retrieving and displaying the corresponding face expression based on the user input
        System.out.println(Food.getFaceByFoodName(food));
    }
}
