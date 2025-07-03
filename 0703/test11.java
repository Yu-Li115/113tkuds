import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int j = 0; j < M; j++) {
                int colSum = 0;
                for (int i = 0; i < N; i++) {
                    colSum += arr[i][j];
                }
                System.out.println(colSum);
                if (j < M - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }
}
