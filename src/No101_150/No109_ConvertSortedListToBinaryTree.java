package No101_150;

import Data_Structures.ListNode;
import Data_Structures.TreeNode;

public class No109_ConvertSortedListToBinaryTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode midNode = findMiddleListNode(head);

        TreeNode node = new TreeNode(midNode.val);

        if(head == midNode){
            return node;
        }

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(midNode.next);

        return node;
    }

    private ListNode findMiddleListNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null){
            prev.next = null;
        }

        return slow;
    }
}
