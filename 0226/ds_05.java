public class ds_05 {
  public static void main(String[] args) {
      int[] numbers = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

      int sum = 0;

      for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
      }
      System.out.println("總和: " + sum);
    }
}
