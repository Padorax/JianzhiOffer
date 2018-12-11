import java.util.Arrays;

public class isContinuous {

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;

        Arrays.sort(numbers);
//        check if number of 0's is bigger than number of interval
        int zero = 0, interv = 0;
//        for (int num:numbers) {
//        zeros are all in the front
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] == 0) {
                zero++;
                continue;
            }
//            return false if contain duplicate non-zero elements
            if (numbers[i] == numbers[i+1]) return false;
            interv += numbers[i+1] - numbers[i] - 1;
        }
        return (zero-interv >= 0);
    }

    public static void main(String[] args) {
        isContinuous s= new isContinuous();
        int [] a1 = {1, 3, 5, 0, 0};
        int [] a2 = {1, 2, 3, 4, 0};
        int [] a3 = {1, 2, 5, 0};
//        int [] a3 = {1, 2, 3, 2};
        System.out.print(s.isContinuous(a1));
        System.out.print(s.isContinuous(a2));
        System.out.print(s.isContinuous(a3));
    }
}
