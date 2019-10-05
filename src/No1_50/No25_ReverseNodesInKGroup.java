package No1_50;

import Data_Structures.ListNode;

public class No25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode prev = dummy;

        while(p != null){
            prev = p;
            for(int i = 0; i < k; i++){
                p = p.next;
                if(p == null){
                    return dummy.next;
                }
            }

            p = reverse(prev, p.next);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode prev, ListNode end){
        ListNode p = prev.next;
        while(p.next != end){
            ListNode n = p.next;
            p.next = n.next;
            n.next = prev.next;
            prev.next = n;
        }
        return p;
    }
}

