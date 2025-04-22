
package Midterm;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Restaurant_OrderingSystem {

    static final String username_password = "C:\\Users\\Dell\\Desktop\\OrderingSystem.txt";
    static final int SHIFT = 3;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n Welcome to our Restaurant Ordering System!! ");
            System.out.println("1. Create an Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please Enter your Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 ->
                    createAccount();
                case 2 -> {
                    if (login()) {
                        orderMenu();
                    }
                }
                case 3 ->
                    System.out.println("Thank you so much! Goodbye.");
                default ->
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    static void createAccount() {
        try {
            System.out.print("Enter your Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your Password: ");
            String password = scanner.nextLine();
            String encryptedPassword = encrypt(password);

            FileWriter writer = new FileWriter(username_password, true);
            writer.write(username + "," + encryptedPassword + "\n");
            writer.close();

            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error while creating account: " + e.getMessage());
        }
    }

    static boolean login() {
        try {
            System.out.print("Enter your Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your Password: ");
            String password = scanner.nextLine();

            File file = new File(username_password);
            if (!file.exists()) {
                System.out.println("No user data found. Please register first.");
                return false;
            }

            Scanner fileScanner = new Scanner(new FileReader(username_password));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] account = line.split(",");
                if (account.length == 2) {
                    String Username = account[0];
                    String Password = decrypt(account[1]);

                    if (username.equals(Username) && password.equals(Password)) {
                        System.out.println("Login successful! Welcome " + username);
                        fileScanner.close();
                        return true;
                    }
                }
            }
            fileScanner.close();
            System.out.println("Login failed. Invalid username or password.");
        } catch (IOException e) {
            System.out.println("Error login: " + e.getMessage());
        }
        return false;
    }

    static void orderMenu() {
        String[] items = {"Chicken Curry", "Adobong Manok", "Fried Chicken"};
        double[] prices = {200, 50, 40};
        int[] quantities = new int[3];

        int option;
        do {
            System.out.println("\n Tuktugaok Menu! ");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " - P" + prices[i]);
            }
            System.out.println("4. Exit and Show eceipt");
            System.out.print("Choose an item: ");
            option = Integer.parseInt(scanner.nextLine());

            if (option >= 1 && option <= 3) {
                System.out.print("Enter quantity for " + items[option - 1] + ": ");
                int qty = Integer.parseInt(scanner.nextLine());
                quantities[option - 1] += qty;
                System.out.println(qty + " " + items[option - 1] + "(s) added.");
            } else if (option != 4) {
                System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        System.out.println("\n Order Summary ");
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                double TotalBill = prices[i] * quantities[i];
                System.out.println(items[i] + " x " + quantities[i] + " = P" + String.format("%.2f", TotalBill));
                total += TotalBill;
            }
        }
        System.out.println("Total Bill: P" + String.format("%.2f", total));
    }

    static String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char x : text.toCharArray()) {
            encrypted.append((char) (x + SHIFT));
        }
        return encrypted.toString();
    }

    static String decrypt(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (char x : text.toCharArray()) {
            decrypted.append((char) (x - SHIFT));
        }
        return decrypted.toString();
    }
}