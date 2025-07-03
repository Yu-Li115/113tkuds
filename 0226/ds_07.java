
public class ds_07 {

    public static void main(String[] args) {
        int[][] numbers = {
            {1, 2, 3}, {2, 5, 6}, {7, 5, 9}
        };

        for (int[] row : numbers) {

            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
