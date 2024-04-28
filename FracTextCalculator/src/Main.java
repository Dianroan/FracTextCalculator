import java.util.Scanner;

/**
 * @author Dianroan
 * The fault in our programs
 */

public class Main {
    public static void main(String[] args) {
        FractionInputParser parser = new FractionInputParser();
        Scanner scanner = new Scanner(System.in);
        String choice = "S";
        while (choice.equals("S")) {
            parser.fractionOperationWithString();
            parser = new FractionInputParser();
            System.out.println("¿Desea realizar otra operación? (S/N)");
            choice = scanner.nextLine();
        }
    }
}