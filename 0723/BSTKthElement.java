
public class BSTKthElement {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int count = 0;
    private static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {
        if (node == null || result != -1) {
            return;
        }
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        System.out.println(kthSmallest(root, 1));
        System.out.println(kthSmallest(root, 3));
        System.out.println(kthSmallest(root, 7));
    }
}
