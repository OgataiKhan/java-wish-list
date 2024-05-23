package org.wishlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wishlist {
    public static void main(String[] args) {
        // Open Scanner
        Scanner scanner = new Scanner(System.in);

        // Create ArrayList & utility variables
        ArrayList<String> wishlist = new ArrayList<>();
        boolean stop = false;
        String addMore, gift;

        // Add gifts to ArrayList
        while(!stop){
            System.out.println("Your list is " + wishlist.size() + " gifts long!");
            System.out.print("Would you like to add another gift? (y)/(n) ");
            addMore = scanner.nextLine().trim();
            switch (addMore){
                case "y":
                    try {
                        System.out.print("What is your gift? ");
                        gift = scanner.nextLine().trim();
                        if (gift.trim().isEmpty()) {
                            throw new IllegalArgumentException("Gift cannot be empty");
                        }
                        wishlist.add(gift);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
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
        System.out.println(wishlist);

        // Close Scanner
        scanner.close();
    }
}
