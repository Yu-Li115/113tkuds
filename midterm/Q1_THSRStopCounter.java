
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
 * 說明：走訪陣列一次找出起點與終點索引，線性時間完成。
 */
