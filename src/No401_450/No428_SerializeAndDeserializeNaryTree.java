package No401_450;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No428_SerializeAndDeserializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        this.serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node root, StringBuilder sb){
        Queue<Node> queue = new LinkedList<>();

        Node endNode = new Node();
        Node childNode = new Node();

        queue.add(root);
        queue.add(endNode);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node == endNode){
                sb.append("#");
                if(!queue.isEmpty()){
                    queue.add(endNode);
                }
            }else if(node == childNode){
                sb.append("$");
            }else{
                sb.append((char) (node.val + '0'));
                for(Node child : node.children){
                    queue.add(child);
                }

                if(queue.peek() != endNode){
                    queue.add(childNode);
                }
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }

        Node root = new Node(data.charAt(0) - '0', new ArrayList<>());
        this.deserializeHelper(data, root);
        return root;
    }

    private void deserializeHelper(String data, Node root){
        LinkedList<Node> currentLevel = new LinkedList<>();
        LinkedList<Node> prevLevel = new LinkedList<>();

        currentLevel.add(root);
        Node parentNode = root;

        for(int index = 1; index < data.length(); index++){
            char d = data.charAt(index);
            if(d == '#'){
                prevLevel = currentLevel;
                currentLevel = new LinkedList<>();

                parentNode = prevLevel.poll();
            }else{
                if(d == '$'){
                    parentNode = prevLevel.poll();
                }else{
                    Node childNode = new Node(d - '0', new ArrayList<>());
                    currentLevel.add(childNode);
                    parentNode.children.add(childNode);
                }

            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
