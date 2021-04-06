package No51_100;

import Data_Structures.ListNode;

public class No61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        if(head == null){
            return head;
        }

        ListNode counter = head;
        while(counter != null){
            counter = counter.next;
            length++;
        }

        int pivot = k % length;

        if(pivot == 0){
            return head;
        }

        ListNode runner = head;
        for(int i = 1; i < length - pivot; i++){
            runner = runner.next;
        }

        ListNode newHead = runner.next;
        ListNode newRunner = newHead;

        while(newRunner.next != null){
            newRunner = newRunner.next;
        }

        runner.next = null;
        newRunner.next = head;
        return newHead;
    }
}
