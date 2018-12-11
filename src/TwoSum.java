import java.util.ArrayList;
import java.util.HashSet;


public class TwoSum {

    /**1. for each element x in array, check if sum-x is in array; increase x and repeat until x >= sum-x
     * if we store array in HashSet, contain is O(1), total is O(n)*/
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();

        HashSet<Integer> data = new HashSet<>();
        for (int i: array) data.add(i);

//        note the first pair has the min product
        for (int i : array) {
            if (data.contains(sum - i)) {
                res.add(i);
                res.add(sum - i);
                return res;
            }
        }

        return res;
    }

    /**2. sorted, from left and right end to middle*/
    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = array.length - 1;

        while(right > left) {
            int curSum = array[left] + array[right];

            if (curSum == sum) {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            } else if (curSum > sum) {
                right --;
            } else {
                left ++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.print(s.FindNumbersWithSum2(a, 7));
    }
}
