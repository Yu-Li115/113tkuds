import java.util.Scanner;

public class test20 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int sum = 0;

            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) {
                    continue; 
                }
                sum += i;
            }

            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }
}
