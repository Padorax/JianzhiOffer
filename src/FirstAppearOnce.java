import java.util.HashMap;

public class FirstAppearOnce {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

//        iterate over str and record frequency in map
//      1.  char [] arr = str.toCharArray(); for (char c: arr)
//      2.
        for (int i = 0, n = str.length(); i < n; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

//        iterate over str and check if value = 1
        for (int i = 0, n = str.length(); i < n; i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "abcabdee";
        FirstAppearOnce sol = new FirstAppearOnce();
        System.out.print(sol.FirstNotRepeatingChar(s));
    }
}
