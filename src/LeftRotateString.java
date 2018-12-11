import java.util.Arrays;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return str;
        char [] temp = str.toCharArray();
        int m = n % str.length();
        if (m == 0) return str;
        char [] t1 = Arrays.copyOfRange(temp, 0, m);
        char [] t2 = Arrays.copyOfRange(temp, m, str.length());
        String s1 = String.valueOf(t1);
        String s2 = String.valueOf(t2);
        return s2 += s1;
    }

    public String LeftRotateString2(String str, int n) {
        if (str == null || str.length() == 0) return str;
        int m = n % str.length();
        if (m == 0) return str;

        String s1 = str.substring(0, m);
        String s2 = str.substring(m, str.length());
//        s2.join(s1);
//        return s2.join(s1);
        String res = String.join("", s2, s1);
//       String res = s1 + s2;
        return res;
    }

    public static void main(String[] args) {
        LeftRotateString s = new LeftRotateString();
        System.out.print(s.LeftRotateString2("abcXYZdef", 1));
    }
}
