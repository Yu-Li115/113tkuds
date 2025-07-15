
import java.util.Scanner;

public class Q10_ArrayToStringUtil {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = null;
            if (n > 0) {
                arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
            } else if (n == 0) {
                arr = new int[0];
            }
            System.out.println(arrayToString(arr));
        }
    }

    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        int len = arr.length;
        if (len == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
            if (i != len - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
