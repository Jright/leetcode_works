package No201_250;

import Data_Structures.ListNode;

public class No203_RemoveElementsFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null){
            if(head.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
