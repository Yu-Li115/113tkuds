import java.util.Scanner;

public class q7permutation {
    static int ops = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        boolean[] used = new boolean[n];
        int[] perm = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        generatePermutations(arr, used, perm, 0);

        System.out.println(ops);

        scanner.close();
    }

    public static void generatePermutations(int[] arr, boolean[] used, int[] perm, int depth) {
        if (depth == arr.length) {

            for (int i = 0; i < perm.length; i++) {
                System.out.print(perm[i]);
                if (i < perm.length - 1) System.out.print(" ");
            }
            System.out.println();
            ops++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = arr[i];
                generatePermutations(arr, used, perm, depth + 1);
                used[i] = false;
            }
        }
    }
}