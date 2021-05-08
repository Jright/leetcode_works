package No201_250;

import java.util.LinkedList;

public class No225_ImplementStackUsingQueues {

    LinkedList<Integer> queue;

    /** Initialize your data structure here. */
    public No225_ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        while(size > 1){
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
