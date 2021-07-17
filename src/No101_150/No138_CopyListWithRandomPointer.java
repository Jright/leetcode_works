package No101_150;

public class No138_CopyListWithRandomPointer {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node runner = head;
        while(runner != null){
            Node temp = runner.next;
            runner.next = new Node(runner.val);
            runner.next.next = temp;
            runner = temp;
        }

        runner = head;
        while(runner != null){
            if(runner.random != null){
                runner.next.random = runner.random.next;
            }
            runner = runner.next.next;
        }

        runner = head;
        Node copyHead = runner.next;
        Node copy = copyHead;
        while(copy.next != null){
            runner.next = runner.next.next;
            runner = runner.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        runner.next = runner.next.next;
        return copyHead;
    }
}
