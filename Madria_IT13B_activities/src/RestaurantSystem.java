import java.io.*;
import java.util.*;

public class RestaurantSystem {

    static final String USER_FILE = "users.txt";
    static final int SHIFT = 3;
    static Scanner scanner = new Scanner(System.in);

    static String[] menuItems = {"Pizza", "Burger", "Fries"};
    static double[] prices = {8.99, 5.49, 2.99};
    static int[] quantities = new int[menuItems.length];

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Restaurant Ordering System ====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> {
                    if (login()) {
                        takeOrder();
                    }
                }
                case 3 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }

    // Caesar cipher encryption
    static String encrypt(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }
        return encrypted.toString();
    }

    // Caesar cipher decryption
    static String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            decrypted.append((char) (c - SHIFT));
        }
        return decrypted.toString();
    }

    static void createAccount() {
        try {
            System.out.print("Enter new username: ");
            String username = scanner.nextLine();

            if (isUserExists(username)) {
                System.out.println("Username already exists.");
                return;
            }

            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            String encryptedPassword = encrypt(password);

            FileWriter fw = new FileWriter(USER_FILE, true);
            fw.write(username + "," + encryptedPassword + "\n");
            fw.close();
            System.out.println("Account created successfully.");

        } catch (IOException e) {
            System.out.println("Error creating account.");
        }
    }

    static boolean isUserExists(String username) throws IOException {
        File file = new File(USER_FILE);
        if (!file.exists()) return false;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(username)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    static boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(USER_FILE));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUser = parts[0];
                String storedEncryptedPass = parts[1];

                if (storedUser.equals(username)) {
                    String decryptedPass = decrypt(storedEncryptedPass);
                    if (decryptedPass.equals(passwordInput)) {
                        System.out.println("Login successful!");
                        br.close();
                        return true;
                    } else {
                        System.out.println("Incorrect password.");
                        br.close();
                        return false;
                    }
                }
            }
            br.close();
            System.out.println("Username not found.");
        } catch (IOException e) {
            System.out.println("Login error.");
        }

        return false;
    }

    static void takeOrder() {
        Arrays.fill(quantities, 0); // reset previous orders if any
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.printf("%d. %s - $%.2f\n", i + 1, menuItems[i], prices[i]);
            }
            System.out.println("0. Finish Order");
            System.out.print("Select item number: ");
            choice = scanner.nextInt();

            if (choice > 0 && choice <= menuItems.length) {
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                quantities[choice - 1] += qty;
                System.out.println(qty + " " + menuItems[choice - 1] + "(s) added to your order.");
            } else if (choice != 0) {
                System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        printBill();
    }

    static void printBill() {
        double total = 0;
        System.out.println("\n==== Order Summary ====");
        for (int i = 0; i < menuItems.length; i++) {
            if (quantities[i] > 0) {
                double itemTotal = prices[i] * quantities[i];
                System.out.printf("%s x %d = $%.2f\n", menuItems[i], quantities[i], itemTotal);
                total += itemTotal;
            }
        }
        System.out.printf("Total Amount: $%.2f\n", total);
        System.out.println("Thank you for ordering!");
    }
}
