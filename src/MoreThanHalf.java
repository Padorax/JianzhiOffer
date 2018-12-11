import java.util.HashMap;

public class MoreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        for(int k : map.keySet()) {
            if (map.get(k) > array.length/2) {
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalf s = new MoreThanHalf();
        int a = s.MoreThanHalfNum_Solution(new int[] {1,2,3,2,2,2,5,4,2});
        System.out.print(a);
    }
}
