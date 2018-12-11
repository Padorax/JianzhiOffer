//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

public class NumAppearOnce {
//    int[] s; default is null not empty int[]
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) return;

//        get the ^ of all elements
        int resultXOR = 0;
        for (int i = 0; i < array.length; i++) resultXOR ^= array[i];

//        find the index of the first 1
        int indexof1 = FindFirstBitsIs1(resultXOR);

//        seperate array to 2 parts according to first1Index is 1 or 0
// and XOR each part separately
        int x1 = 0, x2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (IsBit1(array[i], indexof1)) {
                x1 ^= array[i];
            } else x2 ^= array[i];
        }

        num1[0] = x1;
        num2[0] = x2;
    }

    private int FindFirstBitsIs1(int num) {
        int index = 0;
        while ((num&1) == 0) {
            num = num >> 1;
            index += 1;
        }
        return index;
    }

    private boolean IsBit1(int num, int index) {
        num = num >> index;
        return (num&1) == 1;
    }

    public static void main(String[] args) {
        NumAppearOnce s = new NumAppearOnce();
        int[] a = {1, 2, 1, 3, 4, 5, 4, 5};
//        n1 = [0]
        int n1[] = new int[1];
        int n2[] = new int[1];
        s.FindNumsAppearOnce(a, n1, n2);
        System.out.print(n1[0]);
        System.out.print(n2[0]);
    }
}
