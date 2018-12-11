import java.util.Arrays;

public class GreatestSumOfSubarr {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = (dp[i-1] > 0) ? (dp[i-1] + array[i]): array[i];
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        GreatestSumOfSubarr s= new GreatestSumOfSubarr();
        int[] l = {6,-3,-2,7,-15,1,2,2};
        System.out.print(s.FindGreatestSumOfSubArray(l));
    }
}
