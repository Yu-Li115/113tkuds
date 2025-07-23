
import java.util.*;

public class TreePathProblems {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> rootToLeaves(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> current = new ArrayList<>();
        dfs(root, current, paths);
        return paths;
    }

    private static void dfs(TreeNode node, List<Integer> current, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }
        current.add(node.val);
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(current));
        } else {
            dfs(node.left, current, paths);
            dfs(node.right, current, paths);
        }
        current.remove(current.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static int maxRootToLeafSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = maxRootToLeafSum(root.left);
        int rightSum = maxRootToLeafSum(root.right);
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        System.out.println(rootToLeaves(root));
        System.out.println(hasPathSum(root, 22)); // true
        System.out.println(hasPathSum(root, 26)); // false
        System.out.println(maxRootToLeafSum(root)); // 27 (10->12->...)
    }
}
