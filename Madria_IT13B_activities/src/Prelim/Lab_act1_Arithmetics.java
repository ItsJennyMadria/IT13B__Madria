package Prelim;

import java.util.Scanner;

public class Lab_act1_Arithmetics {

    public static void main(String[] args) {
        int a;
        int b;
        int c;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first Number: ");
        a = in.nextInt();
        System.out.println("Enter the first Number: ");
        b = in.nextInt();
        System.out.println("Enter the first Number: ");
        c = in.nextInt();

        System.out.println(a + " * " + b + " + " + c + " = " + (a * b + c));
        System.out.println("(" + a + " - " + b + " ) " + " % " + c + " = " + ((a - b) % c));
        System.out.println("(" + a + " + " + b + " + " + c + ")" + " / " + " 3 " + " = " + ((a + b + c) / 3));
        System.out.println(a + " * " + c + " - " + "(" + b + " * " + b + ")" + " = " + (a * c - (b * b)));
    }
}
