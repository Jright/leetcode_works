package No951_1000;

import Data_Structures.TreeNode;

import java.util.*;

public class No987_VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<Node>> map = new HashMap<>();

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, root));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.row;
            int col = node.col;
            minCol = Math.min(col, minCol);
            maxCol = Math.max(col, maxCol);
            if (!map.containsKey(col)) {
                PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        if (o1.row != o2.row) {
                            return o1.row < o2.row ? 1 : -1;
                        }
                        return o1.treeNode.val < o2.treeNode.val ? 1 : -1;
                    }
                });
                map.put(col, pq);
            }

            map.get(col).offer(new Node(row, col, node.treeNode));
            if (node.treeNode.left != null) {
                queue.add(new Node(row + 1, col - 1, node.treeNode.left));
            }

            if (node.treeNode.right != null) {
                queue.add(new Node(row + 1, col + 1, node.treeNode.right));
            }
        }

        for (int index = minCol; index <= maxCol; index++) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Node> pq = map.get(index);
            while (!pq.isEmpty()) {
                list.add(pq.poll().treeNode.val);
            }
            ans.add(list);
        }
        return ans;
    }

    class Node {
        public int row;
        public int col;
        public TreeNode treeNode;

        public Node(int row, int col, TreeNode treeNode) {
            this.row = row;
            this.col = col;
            this.treeNode = treeNode;
        }
    }
}
