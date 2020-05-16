package No301_350;

import Data_Structures.ListNode;

public class No328_OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenOrigin = even;

        while(odd.next != null && odd.next.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenOrigin;
        return head;
    }

}
