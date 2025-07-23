
public class TreeReconstruction {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inStart;
        while (inRootIndex <= inEnd && inorder[inRootIndex] != rootVal) {
            inRootIndex++;
        }

        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, inRootIndex - 1);
        root.right = buildPreIn(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, inRootIndex + 1, inEnd);

        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
            int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inStart;
        while (inRootIndex <= inEnd && inorder[inRootIndex] != rootVal) {
            inRootIndex++;
        }

        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + leftTreeSize - 1,
                inorder, inStart, inRootIndex - 1);
        root.right = buildPostIn(postorder, postStart + leftTreeSize, postEnd - 1,
                inorder, inRootIndex + 1, inEnd);

        return root;
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

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode treeFromPreIn = buildFromPreIn(preorder, inorder);
        TreeNode treeFromPostIn = buildFromPostIn(postorder, inorder);

        System.out.println(isSameTree(treeFromPreIn, treeFromPostIn)); // true
    }
}
