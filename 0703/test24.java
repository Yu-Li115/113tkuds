import java.util.Scanner;

public class test24 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int result = 1;
            int i = N;

            while (i > 1) {
                result *= i;
                i--;
            }

            System.out.println(result);
        } catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }
}