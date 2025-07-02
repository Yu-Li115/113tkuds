import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11, 13};

        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍:left = " + left + ", right = " + right + ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("結果：已找到！");
        } else {
            System.out.println("結果：沒找到！");
        }

        scanner.close();
    }
}
/*
時間複雜度說明：
這段程式使用的是「二元搜尋法」，每次搜尋都會把搜尋範圍對半縮小，
因此執行次數為 log₂(n)，時間複雜度為 O(log n)，
比線性搜尋的 O(n) 快很多，特別是陣列很大時效果明顯。
空間複雜度為 O(1)，因為只使用固定的變數。
*/