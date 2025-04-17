package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask and validate full name
        String fullName = nameValidator(input, "Please enter your full name: ");

        // Split the name by one
        String[] namePieces = fullName.split("\\s+");


        // Extract name parts
        String firstName = namePieces[0];
        String middleName = "(none)";
        String lastName = namePieces[namePieces.length - 1];

        // Check for middle name (if exactly 3 parts)
        if (namePieces.length == 3) {
            middleName = namePieces[1];
        }

        // Output
        System.out.println("\nFirst name : " + firstName);
        System.out.println("Middle name : " + middleName);
        System.out.println("Last name : " + lastName);
    }

    // Validates name input
    public static String nameValidator(Scanner input, String message) {
        String name = "";
        while (name.isEmpty()) {
            System.out.print(message);
            name = input.nextLine().trim();
        }
        return name;
    }
}