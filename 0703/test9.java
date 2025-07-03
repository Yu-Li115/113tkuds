
import java.util.Scanner;

public class test9 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double num = scanner.nextDouble();
            System.out.printf("%.2f\n", num);
        }
    }
}
