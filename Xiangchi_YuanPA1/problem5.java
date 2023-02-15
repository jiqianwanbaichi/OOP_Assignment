
/*xiangchi yuan
 * COSI 12b, Fall 2022
 * Programming Assignment #1
 * 
 * Description: problem 5. Input name and use only the pig latin rule to modify name.
 *
 */
import java.util.*;

public class problem5 {
    public static void main(String args[]) {
        // transfer first name to pig latin rule name
        Scanner inputStr1 = new Scanner(System.in); // Create a Scanner object
        System.out.println("first name");
        String first = inputStr1.nextLine(); // Read user input
        first = pigLation(first);
        // transfer second name to pig latin rule name
        Scanner inputStr2 = new Scanner(System.in); // Create a Scanner object
        System.out.println("last name");
        String last = inputStr2.nextLine(); // Read user input
        last = pigLation(last);
        // output final result
        String res = first + " " + last;
        System.out.print(res);

    }

    // method to transfer original name to pig latin name
    public static String pigLation(String name) {
        name = name.toLowerCase();
        // pig latin rule
        name = Character.toUpperCase(name.charAt(1)) + name.substring(2) + name.charAt(0);
        name = name + "ay";
        return name;
    }
}
