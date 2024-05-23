package org.charcounter;

import java.util.HashMap;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        // Open Scanner
        Scanner scanner = new Scanner(System.in);

        // Ask for input
        System.out.println("Enter a string:");
        String input = scanner.nextLine().trim().toLowerCase();

        // Create HashMap
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Loop through input string
        for (char character : input.toCharArray()) {
            // Ignore spaces
            if (character != ' ') {
                if (charCountMap.containsKey(character)) {
                    // If the character is already present, get its count and increase by 1
                    charCountMap.put(character, charCountMap.get(character) + 1);
                } else {
                    // Otherwise, add character and set count to 1
                    charCountMap.put(character, 1);
                }
            }
        }

        // Print result
        for (HashMap.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // Close Scanner
        scanner.close();
    }
}
