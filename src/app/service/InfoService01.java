package app.service;

import app.entity.Client;

import java.util.Scanner;


public class InfoService01 {

    Scanner scanner;
    String name;
    String email;

    public String getData() {
        return formData(getInputs());
    }

    private Client<String, String> getInputs() {
        scanner = new Scanner(System.in);
        System.out.print("Enter client's name: ");
        name = validateInput("[a-zA-Z]+", "Name");
        System.out.print("Enter client's email: ");
        email = validateInput("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]" +
                "+", "Email");
        return new Client<>(name, email);
    }

    private String validateInput(String regex, String fieldName) {
        String input;
        do {
            input = scanner.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Invalid " + fieldName + ". Please enter again.");
            }
        } while (!input.matches(regex));
        return input;
    }

    private String formData(Client<String, String> client) {
        return "Client's name is " + client.key() +
                ", email is " + client.value();
    }
}
