package com.altus.question3.map.lamda.approach;

import java.io.*;
import java.util.*;

@FunctionalInterface
interface Reaction {
    String getFace();
}

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad or Milk To See Child's Face Reaction : ");

        var reactions = Map.of(
            "ice cream", (Reaction) () -> "Happy Face",
            "salad", () -> "Angry Face",
            "milk", () -> "Normal Face"
        );

        var food = reader.readLine().toLowerCase();
        System.out.println(reactions.getOrDefault(food, () -> "Error Face").getFace());
    }
}
