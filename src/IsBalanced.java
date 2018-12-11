import java.util.HashMap;

public class IsBalanced {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private int getDepthMap(TreeNode root) {
//        HashMap<TreeNode, Integer> map = new HashMap<>();
        if (root == null) return 0;

        int l = getDepthMap(root.left), r = getDepthMap(root.right);
        int depth = (l > r) ? l+1 : r+1;
        map.put(root, depth);

        return depth;
    }

//    By definition --check if the left sub tree height and right does not differ more than 1 for every node
//    To avoid revisiting node, record the node height using map in method getDepthMap()
    private boolean IsBalancedHelper(TreeNode root) {
        if (root == null) return true;

        int left = (root.left == null) ? 0 : map.get(root.left), right = map.get(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) return false;

        return IsBalancedHelper(root.left) && IsBalancedHelper(root.right);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepthMap(root);
        map.put(null, 0);
        return IsBalancedHelper(root);
    }

    public static void main(String[] args) {
        IsBalanced s = new IsBalanced();
        TreeNode t = s.new TreeNode(4);
        t.left = s.new TreeNode(3);
        t.right = s.new TreeNode(10);
        t.right.right = s.new TreeNode(2);
        t.right.right.right = s.new TreeNode(7);
//        s.getDepthMap(t);
        System.out.println(s.IsBalanced_Solution(t));
    }
}
