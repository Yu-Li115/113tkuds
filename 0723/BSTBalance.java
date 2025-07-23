
public class BSTBalance {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int balanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static TreeNode mostUnbalancedNode(TreeNode root) {
        return findMostUnbalanced(root, new TreeNode[1], new int[]{Integer.MIN_VALUE});
    }

    private static TreeNode findMostUnbalanced(TreeNode node, TreeNode[] maxNode, int[] maxDiff) {
        if (node == null) {
            return null;
        }
        int bf = balanceFactor(node);
        if (Math.abs(bf) > maxDiff[0]) {
            maxDiff[0] = Math.abs(bf);
            maxNode[0] = node;
        }
        findMostUnbalanced(node.left, maxNode, maxDiff);
        findMostUnbalanced(node.right, maxNode, maxDiff);
        return maxNode[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);

        System.out.println(isBalanced(root));
        System.out.println(balanceFactor(root));
        TreeNode unbalanced = mostUnbalancedNode(root);
        System.out.println(unbalanced != null ? unbalanced.val : "null");
    }
}
