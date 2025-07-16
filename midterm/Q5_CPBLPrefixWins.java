
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
 * 說明：
 * - 建 prefixSum 陣列時，走訪原始陣列一次（n 次加總）。
 * - 每個位置僅需 1 次加法。
 * - 查詢前 k 筆結果只讀取，不做運算（最多 n 次）。
 * 主要運算成本為前綴加總，為 O(n)。
 */
