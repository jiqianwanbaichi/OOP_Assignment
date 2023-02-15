
/*xiangchi yuan
 * COSI 12b, Fall 2022
 * Programming Assignment #1
 * 
 * Description: problem 4. Input message and use caesar cipher to get new encoded message.
 *
 */
import java.util.*;

public class problem4 {
    public static void main(String args[]) {
        // get the message from user and the number of key.
        Scanner inputStr = new Scanner(System.in); // Create a Scanner object
        System.out.println("Your message");
        String input = inputStr.nextLine(); // Read user input

        Scanner inputInt = new Scanner(System.in); // Create a Scanner object
        System.out.println("Encoding key?");
        int key = inputInt.nextInt(); // Read user input
        encoder(input, key);

    }

    // method to encode message.
    private static void encoder(String input, int key) {
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == ' ')
                System.out.print(' ');
            else {
                int asciiNumber = input.charAt(i) + key;
                asciiNumber = (asciiNumber - (int) ('a')) % 26 + (int) ('a');
                char c = (char) asciiNumber;
                c = Character.toUpperCase(c);
                System.out.print(c);
            }
        }

    }
}
