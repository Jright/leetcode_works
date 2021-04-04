package No701_750;

public class No707_DesignLinkedList {

    class Node{
        public int val;
        public Node next;
        public Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    int size = 0;
    Node head;
    Node tail;

    /** Initialize your data structure here. */
    public No707_DesignLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node temp = head;
        for(int i = 0; i <= index; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index < 0 || index > size){
            return;
        }

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        Node node = new Node(val);
        node.next = temp.next;
        node.next.prev = node;
        temp.next = node;
        node.prev = temp;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        Node temp = head;
        for(int i = 0; i <= index; i++){
            temp = temp.next;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp = null;
        size--;
    }
}
