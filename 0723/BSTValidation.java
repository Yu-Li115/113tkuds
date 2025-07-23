
import java.util.*;

public class BSTValidation {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> invalids = new ArrayList<>();
        findInvalidNodesHelper(root, null, null, invalids);
        return invalids;
    }

    private static void findInvalidNodesHelper(TreeNode node, Integer min, Integer max, List<Integer> invalids) {
        if (node == null) {
            return;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            invalids.add(node.val);
        }
        findInvalidNodesHelper(node.left, min, node.val, invalids);
        findInvalidNodesHelper(node.right, node.val, max, invalids);
    }

    public static int nodesToRemove(TreeNode root) {
        int total = countNodes(root);
        int maxBST = largestBSTSubtree(root).size;
        return total - maxBST;
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private static class Info {

        boolean isBST;
        int size;
        int minVal;
        int maxVal;

        Info(boolean isBST, int size, int minVal, int maxVal) {
            this.isBST = isBST;
            this.size = size;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    private static Info largestBSTSubtree(TreeNode node) {
        if (node == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = largestBSTSubtree(node.left);
        Info right = largestBSTSubtree(node.right);
        if (left.isBST && right.isBST && node.val > left.maxVal && node.val < right.minVal) {
            int size = left.size + right.size + 1;
            int minVal = Math.min(left.minVal, node.val);
            int maxVal = Math.max(right.maxVal, node.val);
            return new Info(true, size, minVal, maxVal);
        } else {
            return new Info(false, Math.max(left.size, right.size), 0, 0);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST(root));
        System.out.println(findInvalidNodes(root));
        System.out.println(nodesToRemove(root));
    }
}
