import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

/**
 *
 *
 * @author Sai Rithvik Vaikuntam
 */


public class Urinals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input_type;
        System.out.println("Select Input Type:\n" + "1 -> From Console\n" + "2 -> Use urinal.dat file");
        input_type = sc.nextInt();
        String str = null;
        if (input_type == 1) {
            System.out.println("Enter the String in the console");
            str = sc.next();
        } else if (input_type == 2) {

        }
        if (Methods.goodString(str)) {
            System.out.println("Counts Urinals");
        }
        else
    }
}
