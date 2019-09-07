package No151_200;

import java.util.Stack;

public class No155_MinStack {


    Stack<Integer> stack;
    int minValue = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public No155_MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        if(x <= minValue){
            stack.push(minValue);
            minValue = x;

        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == minValue){
            minValue = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}
