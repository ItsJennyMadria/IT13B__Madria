package Midterm;

public class Fibonacci_Loop_act {

    public static void main(String[] args) {
        int n = 10;
        System.out.print("The Fibonacci Sequence of " + n + " are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " , ");

        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
