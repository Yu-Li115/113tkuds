import java.util.Scanner;

public class test21 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double r = sc.nextDouble();
            double area = 3.14 * r * r;
            System.out.printf("%.2f\n",area);
        }
        catch (Exception e) {
            System.out.println("輸入錯誤：" + e.getMessage());
        }
    }    
}
