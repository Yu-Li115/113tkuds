import java.util.Scanner;

public class test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][][] cube = new int[N][N][N];
        int num = 1;

        int layers = (N + 1) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int start = layer;
            int end = N - 1 - layer;

            for (int x = start; x <= end; x++) {
                for (int y = start; y <= end; y++) {
                    for (int z = start; z <= end; z++) {
                        if (cube[x][y][z] == 0) {
                            cube[x][y][z] = num++;
                        }
                    }
                }
            }
        }

        for (int z = 0; z < N; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    System.out.print(cube[x][y][z]);
                    if (y != N - 1) System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }
}

