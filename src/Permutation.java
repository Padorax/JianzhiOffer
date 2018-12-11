import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        dfs(chars, "", res, chars.length);
        return res;
    }

    private void dfs(char[] arr, String perm, ArrayList<String> res, int depth) {
        for(int i = 0; i < arr.length; i++) {
            if (depth == 0) {
                if (!res.contains(perm)) {
                    res.add(perm);
                    return;
                }
            }
            /*
            char temp = arr[i];
            arr[i] = ' ';
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] != ' ') {
                    dfs(arr, perm+arr[j], res, depth-1);
                }
            }*/

//          can also use arr[i] in perm to avoid reusing character
//            cons: input 'aa' -> [aa, aa]
            if (arr[i] != ' ') {
                char temp = arr[i];
                arr[i] = ' ';
                dfs(arr, perm+temp, res, depth-1);
                arr[i] = temp;
            }

//  cons: 'aa' -> []
/**            if (perm.indexOf(arr[i]) == -1) {
                dfs(arr, perm+arr[i], res, depth-1);
            }*/

        }
    }

    /** Methods from jzOffer, using recursion*/
    public ArrayList<String> permutation2(String str) {
        if (str == null) return null;
        char[] arr = str.toCharArray();
        permutation2(0, 0, arr);
//        permutation2(0, 0, str);

        return null;
    }

    private ArrayList<String> permutation2(int c, int begin, char[] arr) {
        ArrayList<String> res = new ArrayList();
        if (begin == arr.length) res.add(String.valueOf(arr));
        else {
            for (int i = begin; i < arr.length; i++) {
                char temp = arr[i];
                temp = arr[begin];
//                string is immutable


            }
        }


        return null;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<String> s1 = p.Permutation("abc");
        ArrayList<String> s2 = p.Permutation("aa");
        System.out.print(s1);
        System.out.print(s2);
    }
}
