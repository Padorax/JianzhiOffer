import java.util.ArrayList;
import java.util.ArrayDeque;

public class leverOrder {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
//BFS
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayDeque<TreeNode> fringe = new ArrayDeque<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) return nodes;
        fringe.addLast(root);
        while (!fringe.isEmpty()) {
            TreeNode node = fringe.removeFirst();
            nodes.add(node.val);
            if (node.left != null) fringe.addLast(node.left);
            if (node.right != null) fringe.addLast(node.right);
        }

        return nodes;
    }

    public static void main(String[] args) {
        leverOrder s = new leverOrder();
        TreeNode t = s.new TreeNode(1);
        t.left = s.new TreeNode(2);
//        t.right = s.new TreeNode(3);
        t.left.left = s.new TreeNode(4);
//        t.right.right = s.new TreeNode(5);
        ArrayList<Integer> a = s.PrintFromTopToBottom(t);
        System.out.print(a);
    }

}
