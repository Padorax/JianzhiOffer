import sun.reflect.generics.tree.Tree;

import java.util.HashSet;

public class isSubTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
//find R node in root1 where R.val == root2.val
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
//        if (root2.left == null && root2.right == null) {
//            return root2.val == root1.val;
//        }
        boolean res = false;
//        if (root1 != null && root2 != null) {
        if (root1 != null) {
            if (root1.val == root2.val) res = hasTree2(root1, root2);
            if (!res) res = HasSubtree(root1.left, root2);
            if (!res) res = HasSubtree(root1.right, root2);
        }
        return res;
    }

    private boolean hasTree2(TreeNode t1, TreeNode t2) {
//      if t2 == null
        if (t2 == null) return true;
//        t2 != null but t1 is null
        if (t1 == null) return false;
        if (t1.val != t2.val) return false;
        return hasTree2(t1.left, t2.left) && hasTree2(t1.right, t2.right);
    }

    public static void main(String[] args) {
        isSubTree sol = new isSubTree();
        TreeNode t1 = sol.new TreeNode(1);
        t1.left = sol.new TreeNode(2);
        t1.right = sol.new TreeNode(3);
        t1.left.left = sol.new TreeNode(4);
        t1.left.right = sol.new TreeNode(5);
        TreeNode t2 = sol.new TreeNode(1);
        t2.left = sol.new TreeNode(2);
        t2.right = sol.new TreeNode(3);
        System.out.println(sol.HasSubtree(t1, t2));
    }

}
