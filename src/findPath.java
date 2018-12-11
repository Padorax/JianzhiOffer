import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class findPath {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
// all pos?
//    path is current search path, res records all succesful search path (in-place)
    private void dfs(TreeNode node, int num, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (node == null || num < 0) return;
        if (node.left == null && node.right == null && num-node.val == 0) {
            ArrayList<Integer> path2 = new ArrayList<>(path);
            path2.add(node.val);
            res.add(path2);
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>(path);
        path2.add(node.val);
        dfs(node.left, num-node.val, path2, res);
        dfs(node.right, num-node.val, path2, res);
    }
//    DFS + early return
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(root, target, path, res);
//        sort res according to path length
        Collections.sort(res, new myComparator());
        return res;
    }

//compare ArrayList<int> according to length
    class myComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
//            reverse order
            return l2.size() - l1.size();
        }

    }
    public static void main(String[] args) {
        findPath s = new findPath();
        TreeNode t = s.new TreeNode(4);
        t.left = s.new TreeNode(3);
        t.right = s.new TreeNode(1);
        t.left.left = s.new TreeNode(2);
//        t.left.left.left = s.new TreeNode(1);
        t.left.right = s.new TreeNode(3);
        t.right.right = s.new TreeNode(4);
        System.out.print(s.FindPath(t, 9));
    }
}
