
import java.util.Scanner;

public class Q5_CPBLPrefixWins {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int k = sc.nextInt();

            int[] prefixSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + a[i - 1];
            }

            System.out.print("PrefixSum:");
            for (int i = 1; i <= k; i++) {
                System.out.print(" " + prefixSum[i]);
            }
            System.out.println();
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：建立 prefix sum 陣列需走訪 n 次，計算各位置勝場累積數。
 */
