public class array_mode_count {
    public static void main(String[] args) {

        int[] arr = {3, 7, 3, 1, 1, 1};

        int maxCount = 0;       
        int modeValue = arr[0]; 

        for (int i = 0; i < arr.length; i++) {
            int count = 0; 

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                modeValue = arr[i];
            }
        }

        System.out.println("眾數為：" + modeValue + "，出現 " + maxCount + " 次");
    }
}
/*
時間複雜度說明：
這段程式用了兩層迴圈，外層跑n次，內層也跑n次（比對每個元素與其他所有元素），
所以整體時間複雜度為O(n²)。
這樣的作法在陣列很大時效率不佳。若允許使用 HashMap 等資料結構，
可以把每個元素的次數記錄起來，只跑一次陣列，時間複雜度可降為O(n)。
空間複雜度為O(1)，因為沒有使用額外儲存結構（除了幾個變數）。
*/

