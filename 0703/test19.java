import java.util.Scanner;

public class test19 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            for (int i = 2; i <= N; i++) {
                boolean isPrime = true;

                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break; 
                    }
                }

                if (isPrime) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }
}
