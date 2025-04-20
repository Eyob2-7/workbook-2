package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
     static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        CellPhone myPhone = new CellPhone();
        CellPhone cellPhone1 = new CellPhone();
        //Ask the user
        String sn = question(input,"what is the serial number?");
        String model = question(input,"what is the model of the phone?");
        String carrier = question(input,"who is the carrier?");
        String phoneNumber = question(input,"what is the phone number?");
        String owner= question(input,"who is the owner of the phone?");
        String numberToCall = question(input,"Enter the number to dial:");

        //set the cellphone data on the object
        myPhone.setSerialNumber(Integer.parseInt(sn));
        myPhone.setModel(model);
        myPhone.setCarrier(carrier);
        myPhone.setPhoneNumber(phoneNumber);
        myPhone.setOwner(owner);

        //Call the number entered
        myPhone.dial(numberToCall);

        //set up second phone
        cellPhone1.setSerialNumber(989898);
        cellPhone1.setModel("Iphone 16 Pro-Max");
        cellPhone1.setCarrier("T-Mobile");
        cellPhone1.setPhoneNumber("855-555-2229");
        cellPhone1.setOwner("Eric Swartz");
        //Display Information for both phones
        display(myPhone);
        display(cellPhone1);
        //Make each phone call the other
        myPhone.dial(cellPhone1.getPhoneNumber());
        cellPhone1.dial(myPhone.getPhoneNumber());


    }
     //Method to display details of a CellPhone object
    public static void display(CellPhone phone){
        System.out.println("SN:" + phone.getSerialNumber());
        System.out.println("model:" + phone.getModel());
        System.out.println("carrier:" + phone.getCarrier());
        System.out.println("phone number:" + phone.getPhoneNumber());
        System.out.println("Owner:" + phone.getOwner());
    }
     //This Method asks the user a question and return their input
    public static String question(Scanner input , String message){
        String output;
        System.out.print(message);
         output = input.nextLine();
        return output;
    }
}
