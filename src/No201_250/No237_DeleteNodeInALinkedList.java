package No201_250;

import Data_Structures.ListNode;

public class No237_DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
