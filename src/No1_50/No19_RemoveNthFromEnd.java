package No1_50;

import Data_Structures.ListNode;

public class No19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 1){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = dummy;
        ListNode tail = dummy;

        while(n + 1> 0){
            front = front.next;
            n--;
        }

        while(front != null){
            front = front.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }
}
