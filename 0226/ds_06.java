import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();

        for (int i=0;i<numbers.length;i++) {
            numbers[i]=rand.nextInt(100);
            System.out.println("第" + (i+1) + "個數字:" +numbers[i]);
        }
        int max=numbers[0];
        for(int i=1; i<numbers.length; i++) {
            if (numbers[i]>max) {
                max=numbers[i];
            }
        }
        System.out.println("最大值是: " +max);
    }
}
