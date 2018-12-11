public class NumofOne {
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count ++;
        }
        return count;
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count ++;
//            >>> logical, >> arithmetic(signed)
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumofOne s = new NumofOne();
        assert(s.NumberOf1(5) == 2);
        assert(s.NumberOf1(4) == 1);
        System.out.print(s.NumberOf1(4));
//        assert(s.NumberOf1(-3) == 2);
//        System.out.print(s.NumberOf1(-3) );
        System.out.print(s.numberOf1(-3) );
    }
}
