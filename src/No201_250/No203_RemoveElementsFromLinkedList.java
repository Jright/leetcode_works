package No201_250;

import Data_Structures.ListNode;

public class No203_RemoveElementsFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        helper(dummy, head, val);

        return dummy.next;
    }

    private void helper(ListNode prev, ListNode node, int val){
        if(node != null){
            if(node.val == val){
                prev.next = node.next;
                helper(prev, node.next, val);
            }else{
                helper(node, node.next, val);
            }
        }
    }
}
