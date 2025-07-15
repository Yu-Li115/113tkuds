
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
 * 說明：雙層迴圈選擇排序，每次從剩餘元素中找最大，總比較次數為 n(n-1)/2。
 */
