
import java.util.Scanner;

public class ds_02 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("請輸入半徑: ");
            double radius = scanner.nextDouble();

            double area = Math.PI * radius * radius;

            System.out.println("面積是: " + area);
        }
    }
}
