package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        //Fire up the scanner
        Scanner input = new Scanner(System.in);

        //Create an array of 20 books
        Book[] books = new Book[20];

        // Add books to the array
        books[0] = new Book(1, "978-3-16-148410-0", "The Great Gatsby");
        books[1] = new Book(2, "978-0-452-28423-4", "To Kill a Mockingbird");
        books[2] = new Book(3, "978-0-7432-7356-5", "1984");
        books[3] = new Book(4, "978-0-14-028329-7", "Pride and Prejudice");
        books[4] = new Book(5, "978-0-14-243723-0", "Moby-Dick");
        books[5] = new Book(6, "978-1-5011-8756-3", "Little Women");
        books[6] = new Book(7, "978-0-06-112241-5", "Brave New World");
        books[7] = new Book(8, "978-0-375-72451-2", "The Catcher in the Rye");
        books[8] = new Book(9, "978-0-7434-7704-4", "The Hobbit");
        books[9] = new Book(10, "978-0-06-112008-4", "Fahrenheit 451");
        books[10] = new Book(11, "978-0-14-144246-4", "Jane Eyre");
        books[11] = new Book(12, "978-0-14-143960-0", "Wuthering Heights");
        books[12] = new Book(13, "978-0-14-143955-6", "Great Expectations");
        books[13] = new Book(14, "978-0-375-70509-2", "Life of Pi");
        books[14] = new Book(15, "978-0-7432-7355-8", "Animal Farm");
        books[15] = new Book(16, "978-1-4767-4658-6", "The Book Thief");
        books[16] = new Book(17, "978-0-06-085052-4", "The Alchemist");
        books[17] = new Book(18, "978-1-5011-7321-4", "Where the Crawdads Sing");
        books[18] = new Book(19, "978-0-14-243720-9", "Frankenstein");
        books[19] = new Book(20, "978-0-553-21311-7", "Dracula");

        // Main menu loop
        while (true) {
            System.out.println("\n Welcome to Neighborhood Library");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked out Books");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            // Show available books
            if (choice == 1) {
                System.out.println("\n Available Books:");
                for (int i = 0; i < books.length; i++) {
                    if (!books[i].isCheckedOut()) {
                        System.out.println("id " + books[i].getId() + ". ISBN: " + books[i].getIsbn() + ", Title: " + books[i].getTitle());
                    }
                }

                System.out.print("Select a book id to checkout, or enter 0 to return to the menu: ");
                int id;
                try {
                    id = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, Returning to main menu...");
                    continue;
                }

                if (id == 0) {
                    System.out.println("Checkout canceled.");
                } else if (id > 0 && id <= books.length && books[id - 1] != null) {
                    Book book = books[id - 1];
                    if (!book.isCheckedOut()) {
                        System.out.print("Your name: ");
                        String name = input.nextLine();
                        book.checkout(name);
                        System.out.println("Book checked out!");
                    } else {
                        System.out.println("That book is already checked out.");
                    }
                } else {
                    System.out.println("Invalid book ID.");
                }
                // Show checked out books
            } else if (choice == 2) {
                System.out.println("\nChecked Out Books:");
                for (Book b : books) {
                    if (b.isCheckedOut()) {
                        System.out.println(b.getId() + ". " + b.getTitle() + " - Checked out to: " + b.getCheckedOutTo());
                    }
                }

                System.out.print("\nEnter 'C' to check in, or enter 'X' to return to the menu: ");
                String optionResponse = input.nextLine().trim().toUpperCase();

                if (optionResponse.equals("C")) {
                    System.out.print("Enter a book ID to check in: ");
                    int id;
                    try {
                        id = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Returning to main menu.");
                        continue;
                    }

                    if (id > 0 && id <= books.length && books[id - 1] != null) {
                        Book book = books[id - 1];
                        if (book.isCheckedOut()) {
                            book.checkIn();
                            System.out.println("Book checked in!");
                        } else {
                            System.out.println("That book is not checked out.");
                        }
                    } else {
                        System.out.println("Invalid book ID.");
                    }

                } else if (optionResponse.equals("X")) {
                    System.out.println("Returning to main menu...");
                } else {
                    System.out.println("Invalid option. Returning to main menu.");
                }
                // Exit
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
                // invalid menu
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}