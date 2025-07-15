
import java.util.Scanner;

public class Q4_TieredElectricBill {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            int total = 0;

            for (int i = 0; i < n; i++) {
                int kWh = sc.nextInt();
                int bill = calc(kWh);
                total += bill;
                System.out.println("Bill: $" + bill);
            }

            int average = Math.round((float) total / n);
            System.out.println("Total: $" + total);
            System.out.println("Average: $" + average);
        }
    }

    private static int calc(int kWh) {
        double amount = 0;

        int[] limits = {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

        int remaining = kWh;

        for (int i = 0; i < limits.length && remaining > 0; i++) {
            int use = Math.min(remaining, limits[i]);
            amount += use * rates[i];
            remaining -= use;
        }

        return (int) Math.round(amount);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每個用電量在常數時間內計算出電費，總共處理 n 筆資料，為線性時間。
 */
