import java.util.ArrayList;

public class ContSeqSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

//        suppose desired sequence start from i
        for (int i = 1; i <= sum/2; i++) {
//            if such sequnce(from i) exist, sequence length n should be integer n
            double n = (1-2*i+Math.sqrt(8*sum+(2*i-1)*(2*i-1)))/2.0;
//            check if n is int
            if (n % 1 == 0) {
//                or int n == n
                ArrayList<Integer> a = new ArrayList<>();
//                contruct sequence [i, i+n-1]
                for (int j = 0; j < (int) n; j++) a.add(j + i);
                res.add(a);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ContSeqSum s = new ContSeqSum();
        ArrayList<ArrayList<Integer>> res = s.FindContinuousSequence(3);
        System.out.print(res);
    }
}
