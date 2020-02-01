package No1_50;

import Data_Structures.ListNode;

import java.util.PriorityQueue;

public class No23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val == o2.val)
                return 0;
            else
                return 1;
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode listNode : lists) {
           if(listNode != null){
               pq.add(listNode);
           }
        }

        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;

            if(tail.next != null){
                pq.add(tail.next);
            }
        }

        return dummy.next;

    }
}
