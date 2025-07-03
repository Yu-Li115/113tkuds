
import java.util.Scanner;

public class printname {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = scanner.nextLine();
            System.out.println(name);
        }
    }
}
