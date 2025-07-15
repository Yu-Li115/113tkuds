
import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();

            String[] stations = new String[n];
            int[][] prices = new int[n][2];

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                String[] parts = line.split("\\s+");
                stations[i] = parts[0];
                prices[i][0] = Integer.parseInt(parts[1]);
                prices[i][1] = Integer.parseInt(parts[2]);
            }

            System.out.println("Station|Standard|Business");
            for (int i = 0; i < n; i++) {
                System.out.printf("%s|%d|%d\n", stations[i], prices[i][0], prices[i][1]);
            }
        }
    }
}
