
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
 * 這題主要是要找出起點和終點的索引，我們只需從停靠站陣列走訪一次（n 個站），
 * 每個站都看一次是否是起點或終點，最多做 2 次比較，
 * 因此時間是跟站數 n 成正比，算是線性時間 O(n)。
 */
