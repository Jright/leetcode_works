package No401_450;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class No430_FlattenAMultiLevelDoublyLinkedList {

    public Node flatten(Node head) {
        if(head == null){
            return null;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Node runner = head;

        while(runner != null){
            if(runner.child != null){
                if(runner.next != null){
                    stack.push(runner.next);
                }
                runner.next = runner.child;
                runner.next.prev = runner;
                runner.child = null;
            }else if(runner.next == null && !stack.isEmpty()){
                runner.next = stack.pop();
                runner.next.prev = runner;
            }
            runner = runner.next;
        }
        return head;
    }
}
