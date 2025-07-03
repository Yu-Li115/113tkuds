
import java.util.Scanner;

public class test5 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int celsius = scanner.nextInt();
            int fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println(fahrenheit);
        }
    }
}
