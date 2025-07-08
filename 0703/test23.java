import java.util.Scanner;

public class test23 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.printf("%4d", i * j); // 每個數字寬度4，右對齊
                }
                System.out.println(); // 換行
            }
        } catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }
}
