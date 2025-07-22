
public class gcd {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("請輸入兩個整數（以空格分隔）：");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int result = gcd(a, b);
            System.out.println("最大公因數為：" + result);
        }
    }
}
