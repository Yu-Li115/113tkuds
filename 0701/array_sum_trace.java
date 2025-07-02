public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        int total = 0;

        for (int i = 0; i < arr.length ; i++) {
            System.out.println("加總過程: total = "+total+"+"+arr[i]+"="+(total+arr[i]));
            total += arr[i];
        }

        System.out.println("總和為:"+total);
    }
}
/* 時間複雜度說明：這個程式用一個for把陣列裡的每個數字都加起來，
每次只做一次加法和輸出訊息，所以每次的執行時間都是固定的，
整體就是跑n次，時間複雜度是O(n)，n 是陣列的長度。
然後只用了total這個變數來累加，所以空間複雜度是O(1)
*/