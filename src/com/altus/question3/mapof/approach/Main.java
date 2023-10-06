package com.altus.question3.mapof.approach;

import java.io.*;
import java.util.*;


public class Main {

    /**
     * takes user input representing a type of food
     * and prints the child's facial expression in response to being given that food.
     *
     * @param args Command-line arguments passed during the application start. Not used in this application.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {

        var reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad, or Milk To See Child's Face Reaction : ");

        // Defining a map to associate food types with corresponding face expressions
        var reactions = Map.of(
                "ice cream", "Happy Face",
                "salad", "Angry Face",
                "milk", "Normal Face"
        );

        // Reading user input, converting it to lowercase and storing it in 'food'
        var food = reader.readLine().toLowerCase();

        // Retrieving and displaying the corresponding face expression based on user input
        System.out.println(reactions.getOrDefault(food, "Error Face"));
    }
}
