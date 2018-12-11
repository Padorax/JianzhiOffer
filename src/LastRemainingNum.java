public class LastRemainingNum {
//recursive
//    f(n, m) = 0, n=1 | [f(n-1, m)+m]%n, n>1
    public static int LastRemaining_Solution(int n, int m) {
//        iteration
        if (n < 1 || m < 1) return -1;

        int last = 0;
        for (int i = 1; i < n; i++) {
//            last = (last + m) % (n);
            last = (last + m) % (i+1);
        }

//        for (int i = 2; i <=n; i++) last = (last + m) % i;

        return last;
    }

    public static void main(String[] args) {
        LastRemainingNum s = new LastRemainingNum();
        System.out.print(LastRemaining_Solution(5, 3));

    }
}
