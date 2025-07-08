import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int max = arr[0];
            int min = arr[0];

            for (int i = 1; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            System.out.println(max + " " + min);
        } catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }
}