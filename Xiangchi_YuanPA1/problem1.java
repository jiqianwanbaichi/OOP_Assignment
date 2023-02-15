
/*xiangchi yuan
 * COSI 12b, Fall 2022
 * Programming Assignment #1
 * 
 * Description: problem 1. Input positive integer and calculate. Print value in e
 *very step and count steps.
 */
import java.util.*;

public class problem1 {
    public static void main(String args[]) {
        // input value from user.
        Scanner inputInt = new Scanner(System.in); // Create a Scanner object
        System.out.println("input a integer");
        int input = inputInt.nextInt(); // Read user input
        System.out.println("Initial value is: " + input); // Output user input
        // if input < 1, print Error, else calculate.
        if (input < 1) {
            System.out.println("Error: input less than 1");

        } else
            cal(input);

    }

    // method to calculate and print
    private static void cal(int input) {

        int count = 0;
        while (input != 1) {
            if (input % 2 == 0) {
                input /= 2;
            } else {
                input = input * 3 + 1;
            }
            System.out.printf("Next value is: %d \n", input);
            count++;
        }
        System.out.printf("Final value: %d, number of operations performed %d\n", input, count);
    }
}
