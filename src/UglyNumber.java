public class UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
//      UglyNums are generated and sorted in order in array
        int[] UglyNums = new int[index];
        UglyNums[0] = 1;
        int nextUglyIndex = 1;

        int Mult2Index = 0, Mult3Index = 0, Mult5Index = 0;

        while(nextUglyIndex < index) {
//            generate next ugly number
            int min = GetMin(UglyNums[Mult2Index] * 2, UglyNums[Mult3Index] * 3, UglyNums[Mult5Index] * 5);
            UglyNums[nextUglyIndex] = min;

//            record T2, T3, T5 index
            while(UglyNums[Mult2Index] * 2 <= UglyNums[nextUglyIndex]) Mult2Index++;
            while(UglyNums[Mult3Index] * 3 <= UglyNums[nextUglyIndex]) Mult3Index++;
            while(UglyNums[Mult5Index] * 5 <= UglyNums[nextUglyIndex]) Mult5Index++;

            nextUglyIndex++;
        }

        int ugly = UglyNums[nextUglyIndex - 1];
        return ugly;

    }

    private int GetMin(int n1, int n2, int n3) {
        int min = (n1 < n2) ? n1 : n2;
        min = (min < n3) ? min : n3;

        return min;
    }

    public static void main(String[] args) {
        UglyNumber s = new UglyNumber();
        int res = s.GetUglyNumber_Solution(8);
        System.out.print(res);
    }
}
