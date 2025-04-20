package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Get user's full name
        String firstName;
        String lastName ;
        while (true) {
            System.out.print("Please enter your First and Last name (eg.Jon Doe): ");
            String fullName = input.nextLine().trim();
            String[] parts = fullName.split(" ");//Split name
            if (parts.length > 1) {
                 firstName = (parts[0]);
                 lastName = parts[parts.length - 1];
                break;
            } else {
                System.out.print("Invalid Input\n");

            }

        }

        // Ask ticket count
        System.out.print("How many tickets would you like? ");
        int numTickets = input.nextInt();
        input.nextLine();

        // Ask the user the date
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String userDate = input.nextLine().trim();

        //Tell java how the user typed the Date
        DateTimeFormatter inputDate = DateTimeFormatter.ofPattern("M/d/yyyy");

        //Define the output date Format in the end
        DateTimeFormatter outputDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //convert the user's input in to a local date
        LocalDate validatedDate = LocalDate.parse(userDate, inputDate);

        //Convert the local Date into a String
        String convertedDate = validatedDate.format(outputDate);

        // Ticket wording
        String pluralSingular;
        if (numTickets == 1) {
            pluralSingular = "ticket";
        } else {
            pluralSingular = "tickets";
        }
        
        // Print confirmation
        System.out.printf("%d %s reserved for %s under %s, %s\n",
                numTickets, pluralSingular, convertedDate, lastName.toUpperCase(), firstName.toUpperCase());
    }

}