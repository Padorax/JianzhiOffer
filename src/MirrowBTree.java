public class MirrowBTree {
    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        Mirror(root.left);
        Mirror(root.right);
//        both okay before or after Mirror(root.left) as temp is reference to left
//        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        MirrowBTree s = new MirrowBTree();
        TreeNode t = s.new TreeNode(1);
        t.left = s.new TreeNode(2);
        t.right = s.new TreeNode(3);
        t.left.left = s.new TreeNode(4);
        s.Mirror(t);
    }
}
