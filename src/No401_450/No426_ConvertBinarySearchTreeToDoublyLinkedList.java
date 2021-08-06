package No401_450;

public class No426_ConvertBinarySearchTreeToDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if(root != null){
            Node head = new Node();
            Node prev = head;
            Node curr = root;
            while(curr != null){
                if(curr.left == null){
                    curr.left = prev;
                    prev.right = curr;
                    prev = curr;
                    curr = curr.right;
                }else{
                    Node rightMost = curr.left;
                    while(rightMost.right != null && rightMost.right != curr){
                        rightMost = rightMost.right;
                    }

                    if(rightMost.right == null){
                        rightMost.right = curr;
                        Node temp = curr;
                        curr = curr.left;
                        temp.left = null;
                    }
                }
            }
            prev.right = head.right;
            head.right.left = prev;
            head = head.right;
            return head;
        }
        return null;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
