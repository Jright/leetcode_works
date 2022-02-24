package No101_150;

import Data_Structures.ListNode;

public class No148_SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(left != null & right != null){
            if(left.val < right.val){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }else{
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }

        tail.next = (left != null) ? left : right;
        return dummy.next;
    }

    private ListNode getMid(ListNode head){
        ListNode midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
