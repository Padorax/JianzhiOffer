public class IntExp {
//    public static double Power(double base, int exponent) {
//        if (exponent == 0) return 1;
//        return base*Power(base, exponent - 1);
//    }

    public static double Power(double base, int exponent) {
        boolean IsInvalid = false;
        if (base == 0.0 && exponent < 0) {
            IsInvalid = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0) absExponent = -exponent;
        double res = absPower(base, absExponent);
        if (exponent < 0) res = 1.0 / res;
        return res;
    }

//    private static double absPower(double base, int exponent) {
//        double res = 1.0;
//        for (int i = 0; i < exponent; i++) {
//            res *= base;
//        }
//        return res;
//    }

    private static double absPower(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double res = absPower(base, exponent >> 1);
        res *= res;
//        check if exponent is odd number
        if ((exponent & 0x1) == 1) res *= base;
        return res;
    }

    public static void main(String[] args) {
        System.out.print(IntExp.Power(2.0,-3));
    }
}
