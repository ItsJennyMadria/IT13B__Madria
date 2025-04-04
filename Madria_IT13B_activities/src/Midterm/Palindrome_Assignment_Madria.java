
package Midterm;
import java.util.Scanner;

public class Palindrome_Assignment_Madria {
    
       public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String word = in.nextLine();

        String reversed = "";

        for (int x = word.length() - 1; x >= 0; x--) {
            reversed += word.charAt(x);
        }

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word.toUpperCase() + " is a PALINDROME");
        } else {
            System.out.println(word.toUpperCase() + " is NOT a PALINDROME");
        }
    }
}
