
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
 * Time Complexity: O(n^2)
 * 說明：
 * 這題用選擇排序，外層迴圈跑 n 次，內層每次要找到剩餘元素最大值又要跑最多 n 次，
 * 所以大概是 n*(n-1)/2 次比較，
 * 因此時間複雜度是平方時間 O(n²)。
 */
