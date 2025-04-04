
package Midterm;


public class Madria_MultiDimentional_act {
    public static void main(String[] args) {
        int numbers[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        
        };
        
for (int a = 0; a < numbers.length; a++) {
        System.out.print("The Elements in Row " + (a + 1) + ": ");
        for (int b = 0; b < numbers[a].length; b++) { 
    System.out.print(numbers[a][b] + "  ");
}
        System.out.println();
        }
    }
}
