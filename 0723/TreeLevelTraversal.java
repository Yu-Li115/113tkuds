
import java.util.*;

public class TreeLevelTraversal {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 回傳每層節點的 List（之字形）
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    // 只印出每層最後一個節點值
    public static void printLastNodes(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            if (!level.isEmpty()) {
                System.out.println(level.get(level.size() - 1));
            }
        }
    }

    public static void main(String[] args) {
        /*
               1
             /   \
            2     3
           / \   / \
          4   5 6   7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        printLastNodes(zigzag);
    }
}
