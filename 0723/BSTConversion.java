
public class BSTConversion {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] prev = new TreeNode[1];
        TreeNode[] head = new TreeNode[1];
        inorderConvert(root, prev, head);

        head[0].left = prev[0];
        prev[0].right = head[0];
        return head[0];
    }

    private static void inorderConvert(TreeNode node, TreeNode[] prev, TreeNode[] head) {
        if (node == null) {
            return;
        }
        inorderConvert(node.left, prev, head);
        if (prev[0] == null) {
            head[0] = node;
        } else {
            prev[0].right = node;
            node.left = prev[0];
        }
        prev[0] = node;
        inorderConvert(node.right, prev, head);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return root;
    }

    public static void convertBST(TreeNode root) {
        int[] sum = new int[1];
        convertHelper(root, sum);
    }

    private static void convertHelper(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        convertHelper(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convertHelper(node.left, sum);
    }

    public static void inorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode head = bstToDoublyList(root);
        System.out.print("Doubly linked list forward: ");
        TreeNode curr = head;
        for (int i = 0; i < 5; i++) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstRoot = sortedArrayToBST(nums);
        System.out.print("BST inorder: ");
        inorderPrint(bstRoot);
        System.out.println();

        convertBST(bstRoot);
        System.out.print("After convertBST inorder: ");
        inorderPrint(bstRoot);
        System.out.println();
    }
}
