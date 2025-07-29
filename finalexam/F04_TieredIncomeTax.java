
import java.util.Scanner;

public class F04_TieredIncomeTax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] incomes = new int[n];
        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
        }
        sc.close();

        double totalTax = 0;
        for (int income : incomes) {
            double tax = calcTax(income);
            totalTax += tax;
            System.out.printf("Tax: $%.0f\n", tax);
        }
        double avg = totalTax / n;
        System.out.printf("Average: $%.0f\n", avg);
    }

    static double calcTax(int income) {
        double tax = 0;
        if (income <= 560000) {
            tax = income * 0.05;
        } else if (income <= 1260000) {
            tax = 560000 * 0.05 + (income - 560000) * 0.12;
        } else if (income <= 2520000) {
            tax = 560000 * 0.05 + (1260000 - 560000) * 0.12 + (income - 1260000) * 0.20;
        } else if (income <= 4530000) {
            tax = 560000 * 0.05 + (1260000 - 560000) * 0.12 + (2520000 - 1260000) * 0.20 + (income - 2520000) * 0.30;
        } else {
            tax = 560000 * 0.05 + (1260000 - 560000) * 0.12 + (2520000 - 1260000) * 0.20 + (4530000 - 2520000) * 0.30 + (income - 4530000) * 0.40;
        }
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：稅額計算為固定階梯條件，對 n 筆收入逐一計算，整體為線性時間。
 */
