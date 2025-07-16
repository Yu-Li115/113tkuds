
import java.util.Scanner;

public class Q1_THSRStopCounter {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            String[] stops = new String[n];
            for (int i = 0; i < n; i++) {
                stops[i] = sc.next();
            }

            String start = sc.next();
            String end = sc.next();

            int startIdx = -1;
            int endIdx = -1;

            for (int i = 0; i < n; i++) {
                if (stops[i].equals(start)) {
                    startIdx = i;
                }
                if (stops[i].equals(end)) {
                    endIdx = i;
                }
            }

            if (startIdx == -1 || endIdx == -1) {
                System.out.println("Invalid");
            } else {
                int count = Math.abs(startIdx - endIdx) + 1;
                System.out.println(count);
            }

        }
    }
}
/*
 * Time Complexity: O(n)
 * 說明：
 * - 使用一個 for 迴圈，依序比對站名是否為起點或終點。
 * - 最多走訪 n 個站名，每個做最多 2 次 equals 比較。
 * - 其他操作如索引計算為常數時間。
 * 總比較次數最多 2n，屬於 O(n)。
 */
