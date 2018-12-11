public class IsBST {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

//    equal to root.val > root.left.val && root.val < root.right.val &&
//    left sub , right sub both balanced
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;

//        if (root.left != null && root.right != null) {
//            return root.val < root.right.val && root.val > root.left.val &&
//                    IsBalanced_Solution(root.left)
//        }

        return (root.right == null || root.val < root.right.val) && (root.left == null || root.val > root.left.val)
                && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static void main(String[] args) {
        IsBST s = new IsBST();
        TreeNode t = s.new TreeNode(4);
        t.left = s.new TreeNode(3);
        t.right = s.new TreeNode(10);
        t.left.left = s.new TreeNode(2);
        System.out.println(s.IsBalanced_Solution(t));
    }
}
