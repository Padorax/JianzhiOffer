public class FreqInSorted {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0 || k < array[0] || k > array[array.length-1]) return 0;

        int start = 0;
//        while(array[start++] != k) {
        while(array[start] != k) {
            if (start == array.length-1) return 0;
            start += 1;
        }

        int count = 0;
        while(array[start] == k) {
            count ++;
            start ++;
            if (start == array.length) break;
        }

        return count;
    }

    public static void main(String[] args) {
        FreqInSorted s = new FreqInSorted();
        int[] a = {1,1,3,5,5,5,6,8};
//        int res = s.GetNumberOfK(a, 10);
//        b is empty int[] not null
        int[] b = new int[] {};
        int res = s.GetNumberOfK(b, 10);
        System.out.print(res);
    }
}
