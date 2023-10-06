package com.altus.question3.switchcase.approach;

import java.io.*;

public class Main {

    /**
     * @param args Command-line arguments passed during the application start.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {

        var reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad, or Milk To See Child's Face Reaction : ");

        // Step 1: Retrieve the user input
        var food = reader.readLine();

        // Step 2: Convert the input to lowercase to ensure case insensitivity in the comparison
        var lowerCaseFood = food.toLowerCase();

        // Step 3: Evaluate the facial expression using a switch expression
        var childFaceExpression = switch (lowerCaseFood) {
            case "ice cream" -> "Happy Face";
            case "salad" -> "Angry Face";
            case "milk" -> "Normal Face";
            default -> "Error Face";
        };

        // Step 4: Output the resulting facial expression
        System.out.println(childFaceExpression);
    }
}
