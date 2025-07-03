
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int result = (n + n) + (n * 5);
            System.out.println(result);
        }
    }
}
