package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {

     static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        CellPhone myPhone = new CellPhone();

        System.out.println(("what is the serial number?"));
        String sn = input.nextLine();

        System.out.println(("what model is the phone"));
        String model = input.nextLine();

        System.out.println(("who is the carrier?"));
        String carrier = input.nextLine();

        System.out.println(("what is the phone number?"));
        String phoneNumber = input.nextLine();

        System.out.println(("who is the owner of the phone?"));
        String owner= input.nextLine();

        //set the cellphone data on the object
        myPhone.setSerialNumber(Integer.parseInt(sn));
        myPhone.setModel(model);
        myPhone.setCarrier(carrier);
        myPhone.setPhoneNumber(phoneNumber);
        myPhone.setOwner(owner);

        //use the getters to display this info
        System.out.println("SN:" + myPhone.getSerialNumber());
        System.out.println("model:" + myPhone.getModel());
        System.out.println("carrier:" + myPhone.getCarrier());
        System.out.println("phone number:" + myPhone.getPhoneNumber());
        System.out.println("Owner:" + myPhone.getOwner());








    }
}
