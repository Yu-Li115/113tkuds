
import java.util.*;

public class F01_TMRTStopCounter {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            String[] stops = new String[n];
            for (int i = 0; i < n; i++) {
                stops[i] = sc.next();
            }

            String start = sc.next();
            String end = sc.next();

            int startIndex = -1;
            int endIndex = -1;

            for (int i = 0; i < n; i++) {
                if (stops[i].equals(start)) {
                    startIndex = i;
                }
                if (stops[i].equals(end)) {
                    endIndex = i;
                }
            }

            if (startIndex == -1 || endIndex == -1) {
                System.out.println("Invalid");
            } else {
                System.out.println(Math.abs(startIndex - endIndex) + 1);
            }
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：讀取 n 個站名需 O(n)，搜尋起訖站也需掃描一次 O(n)，總計為 O(n)
 */
