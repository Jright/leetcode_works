package No101_150;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class No133_CloneGraph {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }


        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);

        Node copy = new Node(node.val);
        copy.neighbors = new ArrayList<Node>();
        visited.put(node, copy);

        while(!stack.isEmpty()){
            Node pop = stack.pop();
            for(Node item: pop.neighbors){
                if(!visited.containsKey(item)){
                    visited.put(item, new Node(item.val, new ArrayList<Node>()));
                    stack.push(item);
                }
                visited.get(pop).neighbors.add(visited.get(item));
            }
        }

        return visited.get(node);

    }
}
