
package Prelim;
import java.util.Scanner;
public class Lab_act2_ex2Find_The_Greatest_Num {
     public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        
        
        System.out.println("Enter The First Number: ");
        int X = in.nextInt();        
        
        System.out.println("Enter The Second Number: ");
        int Y = in.nextInt();
        
        System.out.println("Enter The Third Number: ");
        int Z = in.nextInt();
        
        
        int A = X;
        if (Y > A) {
            A = Y;
        }
        if (Z > Y) {
            A = Z;
        }
        
        
        System.out.println("The greatest number among the three is: " + A);
        
        in.close();
        
    }
}

