package org.wishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wishlist {
    public static void main(String[] args) {
        // Open Scanner
        Scanner scanner = new Scanner(System.in);

        // File path
        String filePath = "./resources/wishlist.txt";

        // Read existing wishlist from file
        ArrayList<String> wishlist = fileReader(filePath);

        // Add gifts to ArrayList
        boolean stop = false;
        String addMore;
        while (!stop) {
            System.out.println("Your list is " + wishlist.size() + " gifts long!");
            System.out.print("Would you like to add another gift? (y)/(n) ");
            addMore = scanner.nextLine().trim();
            switch (addMore) {
                case "y":
                    try {
                        System.out.print("What is your gift? ");
                        String gift = scanner.nextLine().trim();
                        if (gift.trim().isEmpty()) {
                            throw new IllegalArgumentException("Gift cannot be empty!");
                        }
                        wishlist.add(gift);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "n":
                    stop = true;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }


        // Order and print ArrayList
        Collections.sort(wishlist);
        System.out.println("Here's your wishlist. Enjoy!");
        for (String gift : wishlist) {
            System.out.println("- " + gift);
        }

        // Write updated wishlist to file
        fileWriter(wishlist, filePath);

        // Close Scanner
        scanner.close();
    }

    // Reader method
    public static ArrayList<String> fileReader(String filePath) {
        ArrayList<String> wishlist = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine().trim();
                    wishlist.add(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading from " + filePath + ": " + e.getMessage());
            }
        }
        return wishlist;
    }

    // Writer method
    public static void fileWriter(ArrayList<String> wishlist, String filePath){
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String gift : wishlist) {
                writer.write(gift + System.lineSeparator());
            }
            System.out.println("Wishlist saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Writing error: couldn't write to file");
        }
    }
}
