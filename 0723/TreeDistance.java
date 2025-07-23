
import java.util.*;

public class TreeDistance {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int distance(TreeNode root, int p, int q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        if (lca == null) {
            return -1;
        }
        return distanceFromNode(lca, p, 0) + distanceFromNode(lca, q, 0);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private static int distanceFromNode(TreeNode root, int target, int dist) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            return dist;
        }
        int left = distanceFromNode(root.left, target, dist + 1);
        if (left != -1) {
            return left;
        }
        return distanceFromNode(root.right, target, dist + 1);
    }

    private static int maxDiameter = 0;

    public static int diameter(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftH = height(node.left);
        int rightH = height(node.right);
        maxDiameter = Math.max(maxDiameter, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }

    public static List<Integer> nodesAtDistance(TreeNode root, int dist) {
        List<Integer> res = new ArrayList<>();
        findNodesAtDistance(root, dist, res);
        return res;
    }

    private static void findNodesAtDistance(TreeNode node, int dist, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (dist == 0) {
            res.add(node.val);
            return;
        }
        findNodesAtDistance(node.left, dist - 1, res);
        findNodesAtDistance(node.right, dist - 1, res);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(distance(root, 4, 5));
        System.out.println(distance(root, 4, 3));
        System.out.println(diameter(root));
        System.out.println(nodesAtDistance(root, 2));
    }
}
