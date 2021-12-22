package No101_150;

import Data_Structures.ListNode;

public class No143_ReorderList {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode middle = findMiddleNode(head);

        ListNode second = reverseList(middle);

        ListNode first = head;
        ListNode temp;

        while(second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

    }

    private ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode node){

        if(node == null || node.next == null){
            return node;
        }

        ListNode prev = null;
        ListNode head = node;

        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
