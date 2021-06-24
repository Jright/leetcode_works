package No401_450;

import Data_Structures.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        Deque<ListNode> stack3 = new ArrayDeque<>();
        ListNode dummy = new ListNode(-1);
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        int increment = 0;

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            int value = node1.val + node2.val + increment;
            if(value >= 10){
                value = value - 10;
                increment = 1;
            }else {
                increment = 0;
            }
            ListNode node3 = new ListNode(value);
            stack3.push(node3);
        }

        while(!stack1.isEmpty()){
            ListNode node1 = stack1.pop();
            int value = node1.val + increment;
            if(value >= 10){
                value = value - 10;
                increment = 1;
            }else{
                increment = 0;
            }
            ListNode node3 = new ListNode(value);
            stack3.push(node3);
        }

        while(!stack2.isEmpty()){
            ListNode node2 = stack2.pop();
            int value = node2.val + increment;
            if(value >= 10){
                value = value - 10;
                increment = 1;
            }else{
                increment = 0;
            }
            ListNode node3 = new ListNode(value);
            stack3.push(node3);
        }


        if(increment != 0){
            ListNode node = new ListNode(1);
            stack3.push(node);
            increment = 0;
        }

        ListNode res = dummy;

        while(!stack3.isEmpty()){
            dummy.next = stack3.pollFirst();
            dummy = dummy.next;
        }
        return res.next;
    }
}
