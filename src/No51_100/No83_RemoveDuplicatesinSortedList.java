package No51_100;


public class No83_RemoveDuplicatesinSortedList {
    public ListNode deleteDuplicates(ListNode head){
        ListNode pointer = head;
        if(head == null || head.next == null){
            return head;
        }

        while(pointer != null && pointer.next != null){
            if(pointer.val == pointer.next.val){
                pointer.next = pointer.next.next;
            }else{
                pointer = pointer.next;
            }
        }
        return head;
    }
}

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
