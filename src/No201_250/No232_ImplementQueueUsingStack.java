package No201_250;

import java.util.ArrayDeque;

public class No232_ImplementQueueUsingStack {

    ArrayDeque<Integer> stackA;
    ArrayDeque<Integer> stackB;
    int top;

    /** Initialize your data structure here. */
    public No232_ImplementQueueUsingStack() {
        stackA = new ArrayDeque<>();
        stackB = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stackA.isEmpty()){
            top = x;
        }
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stackB.isEmpty()){
            return stackB.peek();
        }
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
