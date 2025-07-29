
import java.util.Scanner;

public class F02_YouBikeNextFull {

    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();

            String[] times = new String[n];
            int[] minutes = new int[n];
            for (int i = 0; i < n; i++) {
                times[i] = sc.nextLine();
                minutes[i] = timeToMinutes(times[i]);
            }

            String query = sc.nextLine();
            int queryMin = timeToMinutes(query);

            int left = 0, right = n - 1;
            int ansIndex = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (minutes[mid] > queryMin) {
                    ansIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (ansIndex == -1) {
                System.out.println("No bike");
            } else {
                System.out.println(times[ansIndex]);
            }
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在已排序時間陣列中尋找第一個大於查詢時間的元素，時間複雜度為 O(log n)。
 */
