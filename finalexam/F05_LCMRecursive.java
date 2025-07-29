
import java.util.Scanner;

public class F05_LCMRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int gcd = gcd(a, b);
        int lcm = (a / gcd) * b;  // 避免溢位
        System.out.println("LCM: " + lcm);
    }

    static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法每次將大數減小數，最壞情況為 O(max(a,b))。
 */
