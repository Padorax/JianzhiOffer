//Use another stack, every time a node n is stacked, put in second stack the min node
//when n is popped

import java.util.Stack;

public class minStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> supplyStack;

    public minStack() {
        dataStack = new Stack<Integer> ();
        supplyStack = new Stack<>();
    }
    public void push(int node) {
        dataStack.push(node);
        if (supplyStack.isEmpty() == true || supplyStack.peek() > node) supplyStack.push(node);
        else supplyStack.push(supplyStack.peek());
    }

    public void pop() {
        dataStack.pop();
        supplyStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return supplyStack.peek();
    }

    public static void main(String[] args) {
        minStack s = new minStack();
        s.push(3);
        s.push(4);
        assert(s.min() == 3);
        s.push(2);
        assert(s.min() == 2);
        s.push(1);
        assert(s.min() == 1);
        s.pop();
        assert(s.min() == 2);
        s.pop();
        assert(s.min() == 3);
        s.push(0);
        assert(s.min() == 0);
    }
}
