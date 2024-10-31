package org.example;

import org.example.exceptions.NotAuthenticateException;

import java.util.Scanner;

public class Main {

    private final String password = "----------------------";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE BANK");
        System.out.println("Enter your card code: ");
        String cardCode = scanner.nextLine();
        System.out.println("Enter your card pin: ");
        int cardPin = scanner.nextInt();

        try {
            Bank.getInstance().authenticate(cardCode, cardPin);
        } catch (NotAuthenticateException e) {
            System.out.println(e.getMessage());
        }


    }
}