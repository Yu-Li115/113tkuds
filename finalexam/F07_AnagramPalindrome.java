
import java.util.Scanner;

public class F07_AnagramPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        int[] freq = new int[26];
        for (char c : line.toCharArray()) {
            c = Character.toLowerCase(c);
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }

        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 == 1) {
                oddCount++;
            }
        }

        System.out.println(oddCount <= 1 ? "Possible" : "Impossible");
    }
}
