/**Mergesort, record the exchange number of pointer*/

public class InversePair {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) copy[i] = array[i];

        int count = merge(array, copy, 0, array.length-1);

        return count;
    }

    private int merge(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int len = (end - start) / 2;
        int left = merge(copy, data, start, start + len);
        int right = merge(copy, data, start + len + 1, end);

//        last element pos of left part
        int i = start + len;
//        last elemetn pos of right part
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + len + 1) {
            if(data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - len;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }

        for (; i >= start; --i) copy[indexCopy--] = data[i];
        for(; j>= start + len + 1; --j) copy[indexCopy--] = data[j];

        return left + right + count;
    }

    public static void main(String[] args) {
        int[] a = new int[] {7, 5, 6, 4};
        InversePair s = new InversePair();
        System.out.println(s.InversePairs(a));
    }
}
