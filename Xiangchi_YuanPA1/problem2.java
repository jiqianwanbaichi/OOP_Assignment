
/*xiangchi yuan
 * COSI 12b, Fall 2022
 * Programming Assignment #1
 * 
 * Description: problem 2. Input positive integer and output each digit.
 *
 */
import java.util.*;

public class problem2 {
    public static void main(String args[]) {
        // input value from user.
        Scanner inputInt = new Scanner(System.in); // Create a Scanner object
        System.out.println("input a integer");
        int input = inputInt.nextInt(); // Read user input
        System.out.println("Initial value is: " + input); // Output user input
        // Using display method to solve problem.
        display(input);
    }

    // method to calculate each digit and display. Using stack.
    private static void display(int input) {
        Stack<Integer> stack = new Stack<Integer>();
        while (input != 0) {
            int temp = input % 10;
            stack.push(temp);
            input /= 10;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
