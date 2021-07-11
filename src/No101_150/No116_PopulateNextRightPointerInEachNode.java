package No101_150;

public class No116_PopulateNextRightPointerInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        helper(root, root.left);
        helper(root, root.right);

        return root;
    }

    private void helper(Node parent, Node child){

        if(parent == null || child == null){
            return;
        }

        if(parent.next == null){
            if(parent.right == child){
                child.next = null;
            }else{
                child.next = parent.right;
            }
        }else{
            if(parent.right == child){
                child.next = parent.next.left;
            }else{
                child.next = parent.right;
            }
        }

        helper(child, child.left);
        helper(child, child.right);
    }
}
