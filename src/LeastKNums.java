import java.util.ArrayList;
/**First build a maxHeap for the first k elements, then check [k+1, n), if bigger than heap head, continue; else, swap and sink new head*/
public class LeastKNums {
//   in-place
    int[] input;
    int size = 0;


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        this.input = input;
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k > input.length) return res;

        for (int i = 0; i < k; i++) {
//            build maxHeap for first k elements in input--swim to add
//            or can also heapify the first k elements -- sink down from bot to up
            size += 1;
            swim(i);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] <= input[0]) {
                swap(0, i);
                sink(0);
            }
        }

//        obtain first k elements
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

//    swap the ith and jth element in input
    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*(i+1);
    }

    private int parent(int i) {
        return (i-1)/2;
    }

//    sink down the nth item in input
    private void sink(int n) {
        int l = left(n), r = right(n);
        if (n >= size || (l >= size && r >= size)) return;
//        both left and right not null
        if (l < size && r < size) {
            if (input[l] >= input[r]) {
                if (input[l] > input[n]) {
                    swap(l, n);
                    sink(l);
                }
            } else {
                if (input[r] > input[n]) {
                    swap(r, n);
                    sink(r);
                }
            }
//            have left child no right child
        } else if (l < size) {
            if (input[l] > input[n]) {
                swap(l, n);
                sink(l);
            }
//            have right child no left child--never happen for bushy tree
        } else if (r > size) {
            if (input[r] < input[n]) {
                swap(r, n);
                sink(r);
            }
        }
    }

//    swim up the nth item in input
    private void swim(int n) {
        if (n == 0) return;
        int p = parent(n);
        if (input[n] > input[p]) {
            swap(n, p);
            swim(p);
        }
    }

    public static void main(String[] args) {
        LeastKNums s = new LeastKNums();
        int[] l = {4, 5, 1, 6, 2, 7, 3, 1};
        System.out.print(s.GetLeastNumbers_Solution(l, 4));
    }
}
