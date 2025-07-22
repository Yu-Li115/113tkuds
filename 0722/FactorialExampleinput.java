
import java.util.Scanner;

public class FactorialExampleinput {

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個非負整數：");
        int number = scanner.nextInt();

        try {
            int result = factorial(number);
            System.out.println(number + "! = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("錯誤：" + e.getMessage());
        }

        scanner.close();
    }
}
