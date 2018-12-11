public class BtreeToList2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }

    public static void main(String[] args) {
        BtreeToList2 s = new BtreeToList2();
        TreeNode t = s.new TreeNode(10);
        t.left = s.new TreeNode(6);
        t.right = s.new TreeNode(14);
//        t.left.right = s.new TreeNode(8);
//        t.left.left = s.new TreeNode(4);
//        t.right.left = s.new TreeNode(12);
//        t.right.right = s.new TreeNode(16);
        s.Convert(t);
        System.out.print("ass");
    }
}
