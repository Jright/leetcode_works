package No1_50;

import java.util.PriorityQueue;

//TODO 看答案的
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
