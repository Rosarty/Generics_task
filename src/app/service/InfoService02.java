package app.service;

import app.entity.Client;
import app.utils.Rounder;

import java.util.Scanner;


public class InfoService02 {

    Scanner scanner;
    int number;
    double amount;

    public String getData() {
        Client<Integer, Double> client = getInputs();
        return formData(client);
    }

    private Client<Integer, Double> getInputs() {
        scanner = new Scanner(System.in);
        System.out.print("Enter client's phone: ");
        number = scanner.nextInt();
        System.out.print("Enter client's purchase amount: ");
        amount = scanner.nextDouble();
        return new Client<>(number, amount);
    }

    private String formData(Client<Integer, Double> client) {
        String amountRounded = Rounder.roundValue(client.value());
        return "Client's phone is " + client.key() +
                ", purchase amount is USD " + amountRounded;
    }
}
