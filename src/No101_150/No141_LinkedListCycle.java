package No101_150;

public class No141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }


        ListNode runner = head;
        ListNode walker = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            if(runner == walker){
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
