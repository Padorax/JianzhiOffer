public class reOrder {
    public void reOrderArray(int [] array) {
        int[] temp = new int[array.length];
        for (int i=0; i < array.length; i++) temp[i] = array[i];
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if ((temp[i] & 0x1) == 1) {
                array[j] = temp[i];
                j++;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if ((temp[i] & 0x1) == 0) {
                array[j] = temp[i];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        reOrder s = new reOrder();
        int[] arr = {1,2,4,6,3,5,4};
        s.reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
