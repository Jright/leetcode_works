package No51_100;

import Data_Structures.ListNode;

public class No92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }

        if(left == right){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        ListNode con = prev;
        ListNode tail = curr;

        ListNode third = null;

        while(right > 0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            right--;
        }

        if(con != null){
            con.next = prev;
        }else{
            head = prev;
        }

        tail.next = curr;
        return head;
    }
}
