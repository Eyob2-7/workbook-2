package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Required fields
        String firstName = "";
        String lastName = "";

        // Get first name
        while (firstName.length() == 0) {
            System.out.print("First name (Required!): ");
            firstName = input.nextLine().trim().toUpperCase();
        }

        // Optional middle name
        System.out.print("Middle name (optional): ");
        String middleName = input.nextLine().trim().toUpperCase();

        // Get last name
        while (lastName.length() == 0) {
            System.out.print("Last name (Required!): ");
            lastName = input.nextLine().trim().toUpperCase();
        }

        // Optional suffix
        System.out.print("Suffix (optional): ");
        String suffix = input.nextLine().trim();

        // Build full name
        String fullName = firstName;
        if (middleName.length() > 0) {
            fullName += " " + middleName;
        }
        fullName += " " + lastName;
        if (suffix.length() > 0) {
            fullName += ", " + suffix;
        }

        // Print result
        System.out.println("Full name: " + fullName);
    }
}