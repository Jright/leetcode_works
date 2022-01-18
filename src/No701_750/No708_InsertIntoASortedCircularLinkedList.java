package No701_750;

import Data_Structures.Node;

public class No708_InsertIntoASortedCircularLinkedList {
    public Node insert(Node head, int insertVal){
        if(head == null){
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean insert = false;

        do{
            if(prev.val <= insertVal && insertVal <= curr.val){
                insert = true;
            }else if(prev.val > curr.val){
                if(insertVal >= prev.val || insertVal <= curr.val){
                    insert = true;
                }
            }

            if(insert){
                prev.next = new Node(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;

        }while(prev != head);

        prev.next = new Node(insertVal, curr);
        return head;
    }
}
