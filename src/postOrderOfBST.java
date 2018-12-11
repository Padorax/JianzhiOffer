import java.util.Arrays;

public class postOrderOfBST {
//   return length of left tree, arr.length > 1
// if cannot partition, return -1; if no left tree, return 0; if no right tree, return n-1
//    more convenient to return two sub-array?
    private int findLeftLen(int[] arr, int rootVal) {
        int l = 0;
        boolean isLeft = true;
//        here last item in arr is rootVal
        for (int i = 0; i < arr.length; i++) {
//        for (int i = 0; i < arr.length - 1; i++) {
            if (isLeft) {
                if (arr[i] < rootVal) l++;
//                first time reach right
                else isLeft = false;
            } else {
//                check if node in right is less than root
                if (arr[i] < rootVal) return -1;
            }
        }
        return l;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        int n = sequence.length;
        if ( n == 1) return true;
        int leftLen = findLeftLen(sequence, sequence[n-1]);
        if (leftLen == -1) return false;
//      left is empty, check right sub tree
        if (leftLen == 0) return VerifySquenceOfBST(Arrays.copyOfRange(sequence, leftLen, n-1));
//        check left sub tree
        if (leftLen == n-1) return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, n-1));
//        check both left and right
//        boolean f1 = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, leftLen));
//        boolean f2 = VerifySquenceOfBST(Arrays.copyOfRange(sequence, leftLen, n - 1));
//        return f1 && f2;
        return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, leftLen)) &&
                VerifySquenceOfBST(Arrays.copyOfRange(sequence, leftLen, n-1));
    }

    public static void main(String[] args) {
        postOrderOfBST s = new postOrderOfBST();
        int[] seq = {2, 1, 3, 5, 8, 4};
//        int[] s2 = {2, 3, 4, 5};
//        System.out.println(s.findLeftLen(seq, 4));
//        System.out.println(s.findLeftLen(seq, 7));
//        System.out.println(s.findLeftLen(s2, 1));
//        System.out.println(s.findLeftLen(s2, 6));
        System.out.print(s.VerifySquenceOfBST(seq));
        System.out.print(s.VerifySquenceOfBST(null));
        System.out.print(s.VerifySquenceOfBST(new int[]{}));
    }
}
