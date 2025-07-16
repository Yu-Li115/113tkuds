
import java.util.Scanner;

public class Q3_NightMarketRanking {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            double[] scores = new double[n];

            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextDouble();
            }

            for (int i = 0; i < n - 1; i++) {
                int maxIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (scores[j] > scores[maxIdx]) {
                        maxIdx = j;
                    }
                }

                double temp = scores[i];
                scores[i] = scores[maxIdx];
                scores[maxIdx] = temp;
            }

            int limit = Math.min(5, n);
            for (int i = 0; i < limit; i++) {
                System.out.printf("%.1f\n", scores[i]);
            }

        }
    }
}
/*
 * Time Complexity: O(n²)
 * 說明：
 * - 外層 for 需執行 (n - 1) 次。
 * - 每次內層找最大值需比較 (n - i - 1) 次。
 * - 總比較次數約為 n(n-1)/2。
 * 屬於 O(n²) 的選擇排序。
 */
