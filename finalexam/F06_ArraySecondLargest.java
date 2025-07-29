
import java.util.Scanner;

public class F06_ArraySecondLargest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Pair result = findMaxSecond(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    static class Pair {

        int max, second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    static Pair findMaxSecond(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        int mid = (left + right) / 2;
        Pair leftPair = findMaxSecond(arr, left, mid);
        Pair rightPair = findMaxSecond(arr, mid + 1, right);

        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else if (leftPair.max < rightPair.max) {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        } else { // 相等
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.second);
        }
        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：分治遞迴合併，總共對每元素處理一次，為線性時間。
 */
