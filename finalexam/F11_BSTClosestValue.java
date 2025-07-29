
import java.util.Scanner;

public class F11_BSTClosestValue {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            root = insert(root, v);
        }
        int target = sc.nextInt();
        sc.close();

        System.out.println(closestValue(root, target));
    }

    static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val); 
        }else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)
                    || (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }
            if (target < root.val) {
                root = root.left; 
            }else if (target > root.val) {
                root = root.right; 
            }else {
                break;
            }
        }
        return closest;
    }
}
