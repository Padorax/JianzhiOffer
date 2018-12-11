import sun.reflect.generics.tree.Tree;

public class BtreeToList {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
//        inorder traversal
//        if(pRootOfTree == null) return;
//        Convert(pRootOfTree.left);
//        System.out.println(pRootOfTree.val);
//        Convert(pRootOfTree.right);
        TreeNode last = null;
        ConvertNode(pRootOfTree, last);
//        return head pointer
        TreeNode head = last;
        while(head != null && head.left != null) head = head.left;
        return head;
    }

    private void ConvertNode(TreeNode node, TreeNode last) {
//        last points to the largest/last node in linked list that is already converted
        if (node == null) return;
        TreeNode cur = node;

        if (cur.left != null) {
            ConvertNode(cur.left, last);
        }

        cur.left = last;
        if(last != null) {
            last.right = cur;
        }

        last = cur;

        if (cur.right != null) {
            ConvertNode(cur.right, last);
        }
    }

    public static void main(String[] args) {
        BtreeToList s = new BtreeToList();
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
