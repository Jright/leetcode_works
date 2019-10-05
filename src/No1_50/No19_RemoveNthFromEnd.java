package No1_50;

import Data_Structures.ListNode;

public class No19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {//Note: Terrible question, what is this parameter 'head'? why return it when remove the nth
    //element counting from the end? It just does not make any sense.

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }
}
