
package Midterm;

import java.util.Scanner;


public class Simple_Calculator_Using_Methods_Madria {
    public static double add(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b){
        if(b == 0){
            System.out.println("Error! Please note: no division by zero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter the first number: ");
            double num1 = scanner.nextDouble(); // Fixed: Use nextDouble() instead of nextInt()
            
            System.out.print("Please enter the second number: ");
            double num2 = scanner.nextDouble(); // Fixed: Use nextDouble() instead of nextInt()
            
            System.out.println("Now, please select an operation by its corresponding number:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            
            int choice = scanner.nextInt();
            
            double result = 0;
            switch (choice) {
                case 1 -> result = add(num1, num2);
                case 2 -> result = subtract(num1, num2);
                case 3 -> result = multiply(num1, num2);
                case 4 -> result = divide(num1, num2);
                default -> {
                    System.out.println("Invalid choice! please try again.");
                    return;
                }
            }
            
            System.out.printf("Result: %.2f\n", result);
        }
    }
}
