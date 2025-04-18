package com.pluralsight;


import java.util.Scanner;

public class AddressBuilderApp {
    public static void main(String[] args) {

        //========Fire up Scanner=======
        Scanner input = new Scanner(System.in);
        //===========Create a String Builder=====================
        StringBuilder addInfo = new StringBuilder();

        //==============input Full Name=============
        System.out.print("Full name: ");
        String fullName = input.nextLine();

        //input Billing Address
        System.out.print("Billing Street: ");
        String billingStreet = input.nextLine();

        //input Billing City
        System.out.print("Billing City: ");
        String billingCity = input.nextLine();

        //input Billing State
        System.out.print("Billing State: ");
        String billingState = input.nextLine();

        String billingZip = zipValidator(input, "Billing Zip: ");
//==================================================================
        String shippingStreet;
        String shippingCity;
        String shippingState;
        String shippingZip;
        if (isSameAddress(input)) {
            shippingStreet = billingStreet;
            shippingCity = billingCity;
            shippingState = billingState;
            shippingZip = billingZip;
        } else {
            System.out.print("shipping Street: ");
            shippingStreet = input.nextLine();
            System.out.print("ShippingCity: ");
            shippingCity = input.nextLine();
            System.out.print("shipping State: ");
            shippingState = input.nextLine();
            shippingZip = zipValidator(input, "shipping Zip: ");
        }
        //=============Build output Using StringBuilder==============
        addInfo.append(fullName).append("\n");
        addInfo.append("Billing Address:").append("\n");
        addInfo.append(billingStreet).append("\n");
        addInfo.append(billingCity).append(", ").append(billingState).append(" ").append(billingZip).append("\n\n");
        addInfo.append("Shipping Address:").append("\n");
        addInfo.append(shippingStreet).append("\n");
        addInfo.append(shippingCity).append(", ").append(shippingState).append(" ").append(shippingZip).append("\n");

        //==============Display the output==========
        System.out.println(addInfo);

    }

    public static boolean isSameAddress(Scanner input) {
        System.out.print("Is your Shipping address the same as the Billing address?(yes/no):");
        String userAnswer = input.nextLine().trim().toLowerCase();
        return
                userAnswer.equals("yes") || userAnswer.equals("y");

    }

    public static String zipValidator(Scanner input, String message) {
        String zip = "";
        while (true) {
            System.out.print(message);
            zip = input.nextLine().trim();
            if (zip.length() == 5) {
                break;
            } else {
                System.out.print("please enter a valid 5-digit Zip Code");

            }

        }
        return zip;

    }
}
