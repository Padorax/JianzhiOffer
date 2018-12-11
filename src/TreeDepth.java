//tree depth and tree diameter(use class variable to keep track of max diameter rooted at different nodes)
public class TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeDepth s = new TreeDepth();
        TreeNode t = s.new TreeNode(4);
        t.left = s.new TreeNode(3);
        t.right = s.new TreeNode(1);
        t.left.left = s.new TreeNode(2);
        System.out.println(s.TreeDepth(t));
    }
}
