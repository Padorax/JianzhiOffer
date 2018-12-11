public class isNum {

    public boolean isNumeric1(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    public boolean isNumeric(char[] str) {
//        flag, record if '+/-', '.', 'e' has appeared
        boolean sign = false, decimal = false, hasE = false;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
//                e cannot be at the front or rear
                if (i == str.length -1 || i == 0) return false;
//                e cannot follow .
                if (str[i-1] == '.') return false;
//                cannot have duplicate e
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
//                sign either in the front or follow directly after e
                if (i == 0 || (i > 0 && (str[i-1] == 'e' || str[i-1] == 'E'))) {
                    sign = true;
                } else return false;
            } else if (str[i] == '.') {
//                . cannot follow e, . can only appear once
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') return false;
//                invalid character
        }

        return true;
    }

    public static void main(String [] args) {
        isNum s = new isNum();
        assert(s.isNumeric("+100".toCharArray()));
        assert(s.isNumeric("5e2".toCharArray()));
        assert(s.isNumeric("-123".toCharArray()));
        assert(s.isNumeric("-1233.1416".toCharArray()));
        assert(s.isNumeric("-1E-16".toCharArray()));

        assert(!s.isNumeric("12e".toCharArray()));
        s.isNumeric("1a3.14".toCharArray());
        s.isNumeric("1.2.3".toCharArray());
        s.isNumeric("+-5".toCharArray());
        s.isNumeric("12e+4.3".toCharArray());

    }
}
