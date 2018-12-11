import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class printMinNum {

    public String PrintMinNumber(int [] numbers) {
//        Arrays.sort(numbers, new myComparator()); doesnot work...
//        convert input to a list of string
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            arr.add(Integer.toString(numbers[i]));
        }

//        sort using custom myComparator
        Collections.sort(arr, new myComparator());

//        concatenate results

//        String res = "";
//        for (String a : arr) {
//            res += a;
//        }
//        return res;
        return String.join("", arr);
    }

    public class myComparator implements Comparator<String> {
        @Override
        public int compare(String n1, String n2) {
            String c1 = n1 + n2;
            String c2 = n2 + n1;
            return Integer.parseInt(c1) - Integer.parseInt(c2);
        }
    }

    public static void main(String[] args)  {
        printMinNum s = new printMinNum();
        int[] l = {3, 32, 321};
        String res = s.PrintMinNumber(l);
        System.out.println(res);
        assert(res.equals("321323"));

        String t = String.join(" ", "ha", "what", "huh");
        System.out.print(t);
    }
}
