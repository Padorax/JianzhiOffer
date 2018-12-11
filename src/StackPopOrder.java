import java.util.ArrayList;
import java.util.Stack;

public class StackPopOrder {
    public boolean IsPopOrder(int [] pushA, int [] popA) {
        Stack<Integer> stack = new Stack<>();
//      j  record node pos in pushA
        int j = 0;
        for (int i = 0; i < popA.length; i++) {
//            cur node on top of stack
            int node = popA[i];
            if (!stack.isEmpty() && node == stack.peek()) stack.pop();
//            cur node not on top of stack or stack if empty
            else {
//            search cur node in the remaining part of pushA
//                no left value in pushA
                if (j == pushA.length) return false;
                while(pushA[j] != node) {
                    stack.push(pushA[j]);
                    j++;
                    if (j == pushA.length) return false;
                }
//                node is pushed and popped, j++
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args){
        StackPopOrder s = new StackPopOrder();
        int[] o1 = {1, 2, 3, 4, 5};
        int[] o2 = {5, 4, 3, 2, 1};
        int[] o3 = {4, 5, 3, 2, 1};
        int[] o4 = {4, 3, 5, 1, 2};
        System.out.print(s.IsPopOrder(o1, o2));
        System.out.print(s.IsPopOrder(o1, o3));
        System.out.print(s.IsPopOrder(o1, o4));
        assert(s.IsPopOrder(o1, o2) == true);
        assert(s.IsPopOrder(o1, o3) == true);
        assert(s.IsPopOrder(o1, o4) == false);
    }
}
