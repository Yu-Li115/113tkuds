
import java.util.Scanner;

public class test6 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int intNum = scanner.nextInt();
            double doubleNum = scanner.nextDouble();
            double result = intNum + doubleNum;
            System.out.printf("%.2f\n", result);
        }
    }
}
