
public class isSorted {

    public static boolean isSorted(int[] arr, int index) {
        if (arr == null || arr.length <= 1 || index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 5};

        System.out.println(isSorted(arr1, 0));
        System.out.println(isSorted(arr2, 0));
    }
}
