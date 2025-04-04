
package Midterm;


public class Madria_Multi_Dimentional_act {
    public static void main (String[] args){
        int numbers[][] = {
            { 1, 2, 3, 4},
            { 5, 6, 7, 8},
            { 9, 10, 11, 12}
        };
        for (int x = 0; x< numbers.length; x++){
            System.out.println("The Elements of Row" +(x+1) + ":");
            for(int y = 0; y< numbers[x].length; y++){
                System.out.print(numbers [x][y] + " ");
            }
        }System.out.println();
    }
}
