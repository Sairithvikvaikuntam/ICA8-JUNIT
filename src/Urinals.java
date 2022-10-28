import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

/**
 *
 *
 * @author Sai Rithvik Vaikuntam
 */


public class Urinals {
    public static void main(String[] args) throws IOException {
        Methods urinals = new Methods();
        while (true) {
            System.out.println("\n===========");
            System.out.println("1) Read from console \n2) Read from file\n3) Exit");
            System.out.print("Enter your option: ");
            Scanner sc = new Scanner(System.in);
            String next = sc.nextLine();
            switch (next) {
                case "1" -> {
                    System.out.print("Provide input string: ");
                    String inputString = sc.nextLine();
                    if (!urinals.goodString(inputString)) {
                        System.out.println("Invalid input");
                        continue;
                    }
                    int count = urinals.getFreeUrinals(inputString);
                    System.out.print("Free urinals : " + count + "\n");
                }
                case "2" -> {
                    String[] lines = urinals.readFromFile("src/urinal.dat");
                    urinals.writeToFile(lines);
                }
                case "3" -> {
                    System.out.println("Exit...");
                    System.exit(1);
                }
            }
        }
    }
}
