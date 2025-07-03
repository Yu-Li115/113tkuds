import java.util.Scanner;

public class test18 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int Y = sc.nextInt();

            if ((Y % 4 == 0 && Y % 100 != 0) || (Y % 400 == 0)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }
}
