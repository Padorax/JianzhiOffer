//'0'-48
public class StrToInt {
    public int StrToInt(String str) {
        if(str == null || str.length() < 1) return 0;
//remove white spaces
        str = str.trim();

//        check sign
        boolean minus = false;
        int i = 0;
        if (str.charAt(0) == '-') {
            minus = true;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(i) < '0' || str.charAt(i) > '9') return 0;
//        } else if (str.charAt(i) < 48 || str.charAt(i) > 57) return 0;
//        else if (str.charAt(0) != '+') return 0;

//        store result
        double res = 0;

        for ( ; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = res*10 + (str.charAt(i)-'0');
            } else return 0;
        }

//        final result
        if (minus) res = -res;

//        check flow
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;

        return (int) res;
    }

    public static void main(String[] args) {
        StrToInt s = new StrToInt();
        System.out.print(s.StrToInt("123"));
        System.out.print(0+'1');
    }
}
