public class Sum {
//    sum 1+2+3+...+n without using loop, *
    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n, 2) + n);
        return sum >> 1;
    }
}
