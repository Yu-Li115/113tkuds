
import java.util.*;

public class F12_TreeDiameter {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static int diameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        sc.close();

        TreeNode root = buildTree(vals);
        height(root);
        System.out.println(diameter);
    }

    static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) {
            return null;
        }
        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;
        while (!q.isEmpty() && idx < vals.size()) {
            TreeNode cur = q.poll();
            if (idx < vals.size()) {
                int leftVal = vals.get(idx++);
                if (leftVal != -1) {
                    cur.left = new TreeNode(leftVal);
                    q.offer(cur.left);
                }
            }
            if (idx < vals.size()) {
                int rightVal = vals.get(idx++);
                if (rightVal != -1) {
                    cur.right = new TreeNode(rightVal);
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }

    static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftH = height(node.left);
        int rightH = height(node.right);
        diameter = Math.max(diameter, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}
