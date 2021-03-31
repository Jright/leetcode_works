package No301_350;

import Data_Structures.ListNode;

public class No328_OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddRunner = oddHead;
        ListNode evenRunner = evenHead;

        while(oddRunner.next != null && evenRunner.next != null){
            oddRunner.next = oddRunner.next.next;
            oddRunner = oddRunner.next;
            evenRunner.next = evenRunner.next.next;
            evenRunner = evenRunner.next;
        }

        oddRunner.next = evenHead;
        return oddHead;
    }

}
