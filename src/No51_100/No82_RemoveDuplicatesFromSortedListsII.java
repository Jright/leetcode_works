package No51_100;

import Data_Structures.ListNode;

public class No82_RemoveDuplicatesFromSortedListsII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode pre = dummy;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pre.next = head.next;
            }else{
                pre = pre.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
