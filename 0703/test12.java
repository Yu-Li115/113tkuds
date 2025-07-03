import java.util.Scanner;

public class test12 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                    if (j < i) System.out.print(" ");
                }
                for (int j = i - 1; j >= 1; j--) {
                    System.out.print(" " + j);
                }
                System.out.println();
            }
        }
    }
}
