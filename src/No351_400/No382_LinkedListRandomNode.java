package No351_400;

import Data_Structures.ListNode;

public class No382_LinkedListRandomNode {
    private ListNode head;

    public No382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int scope = 1;
        int chosenValue = 0;
        ListNode curr = this.head;
        while (curr != null) {
            if (Math.random() < 1.0 / scope) {
                chosenValue = curr.val;
            }
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;
    }
}
