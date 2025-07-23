
public class TreeComparison {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return null;
        }
        if (root1.val == root2.val) {
            TreeNode left = largestCommonSubtree(root1.left, root2.left);
            TreeNode right = largestCommonSubtree(root1.right, root2.right);
            TreeNode node = new TreeNode(root1.val);
            node.left = left;
            node.right = right;
            return node;
        }
        TreeNode left = largestCommonSubtree(root1.left, root2);
        TreeNode right = largestCommonSubtree(root1.right, root2);
        return (size(left) > size(right)) ? left : right;
    }

    private static int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);

        System.out.println(isSameTree(tree1, tree2)); // false
        System.out.println(isSubtree(tree1, tree2)); // true

        TreeNode common = largestCommonSubtree(tree1, tree2);
        printTree(common); // prints common subtree preorder
    }
}
