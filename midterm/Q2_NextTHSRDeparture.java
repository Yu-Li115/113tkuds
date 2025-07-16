
import java.util.Scanner;

public class Q2_NextTHSRDeparture {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = Integer.parseInt(sc.nextLine());
            int[] times = new int[n];
            String[] timeStrings = new String[n];

            for (int i = 0; i < n; i++) {
                timeStrings[i] = sc.nextLine();
                times[i] = toMinutes(timeStrings[i]);
            }

            String queryTime = sc.nextLine();
            int query = toMinutes(queryTime);

            int idx = binarySearch(times, query);

            if (idx == n) {
                System.out.println("No train");
            } else {
                System.out.println(timeStrings[idx]);
            }

        }
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static int binarySearch(int[] times, int query) {
        int left = 0, right = times.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (times[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
/*
 * Time Complexity: O(log n)
 * 說明：
 * - 將時間字串轉為分鐘數是 O(n) 次字串處理（可忽略）。
 * - 接著對已排序時間陣列做二分搜尋。
 * - 二分搜尋最多比較 log₂n 次（每次折半）。
 * 主運算成本為 binarySearch，為 O(log n)。
 */
