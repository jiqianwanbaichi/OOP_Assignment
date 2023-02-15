
/*xiangchi yuan
 * COSI 12b, Fall 2022
 * Programming Assignment #1
 * 
 * Description: problem 3. Input positive integer and transfer it into roman numerals
 */
import java.util.*;

public class problem3 {
    public static void main(String args[]) {
        Scanner inputInt = new Scanner(System.in); // Create a Scanner object
        System.out.println("input a integer");
        int input = inputInt.nextInt(); // Read user input
        System.out.println("Initial value is: " + input); // Output user input
        // restrict limitation of 4999.
        if (input > 4999) {
            System.out.println("Error: input larger than 4999");
        } else
            transfer(input);

    }

    // through calculate, get the respective symbols then combined together
    private static void transfer(int input) {
        int res = 0;
        StringBuilder builder = new StringBuilder();
        if (input >= 1000) {
            res = input / 1000;
            input %= 1000;
            for (int i = res; i > 0; i--) {
                builder.append('M');
            }
        }

        if (input >= 900) {
            input = input % 900;
            builder.append('C');
            builder.append('M');
        }

        if (input >= 500) {
            input %= 500;
            builder.append('D');
        }

        if (input >= 400) {
            input = input % 400;
            builder.append('C');
            builder.append('D');
        }

        if (input >= 100) {
            res = input / 100;
            input %= 100;
            for (int i = res; i > 0; i--) {
                builder.append('C');
            }
        }

        if (input >= 90) {
            input = input % 90;
            builder.append('X');
            builder.append('C');
        }

        if (input >= 50) {
            input %= 50;
            builder.append('L');
        }

        if (input >= 40) {
            input = input % 40;
            builder.append('X');
            builder.append('L');
        }

        if (input >= 10) {
            res = input / 10;
            input %= 10;
            for (int i = res; i > 0; i--) {
                builder.append('X');
            }
        }

        if (input >= 9) {
            input = input % 9;
            builder.append('I');
            builder.append('X');
        }

        if (input >= 5) {
            input %= 5;
            builder.append('V');
        }

        if (input >= 4) {
            input = input % 4;
            builder.append('I');
            builder.append('V');
        }

        if (input >= 1) {
            res = input / 1;
            input %= 1;
            for (int i = res; i > 0; i--) {
                builder.append('I');
            }
        }

        String Roman = builder.toString();

        System.out.printf(Roman);

    }
}
