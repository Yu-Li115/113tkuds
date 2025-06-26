public class ds_07 {
    public static void main(String[] args) {
        int[][] numbers = {
            {1,2,3},{2,5,6},{7,5,9}
        };

        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers[i].length;j++){
                System.out.println(numbers[i][j]+" ");
            }
            System.out.println();
        }
    }
}
