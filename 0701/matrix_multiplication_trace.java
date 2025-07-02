public class matrix_multiplication_trace {
    public static void main(String[] args) {
        
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };

        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = 0;

                StringBuilder step = new StringBuilder();
                StringBuilder values = new StringBuilder();

                for (int k = 0; k < 2; k++) {
                    int mul = a[i][k] * b[k][j];
                    c[i][j] += mul;

                    step.append(a[i][k] + "*" + b[k][j]);
                    values.append((a[i][k] * b[k][j]));

                    if (k < 1) {
                        step.append(" + ");
                        values.append(" + ");
                    }
                }

                System.out.println("計算位置 c[" + i + "][" + j + "]：" + step + " = " + values + " = " + c[i][j]);
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*
時間複雜度說明：
這段程式使用三層for迴圈：外層i、j是結果矩陣c的列與行，每次都跑2次；
內層k是每個元素的加總來源，也跑2次。
因此總共是2*2*2=8次基本乘加操作，
在一般n*n矩陣相乘的情況下，時間複雜度為O(n^3)。
空間複雜度是O(n^2)，因為產生一個新的n*n結果矩陣。
*/

