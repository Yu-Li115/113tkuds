
import java.util.Scanner;

public class test7 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char ch = scanner.next().charAt(0);
            System.out.println((int) ch);
        }
    }
}
