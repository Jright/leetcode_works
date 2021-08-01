package No301_350;

import Data_Structures.TreeNode;

import java.util.*;

public class No314_BinaryTreeVerticalOrderTraversal {

    class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();

        int column = 0;
        queue.offer(new Pair(root, column));
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            root = pair.node;
            column = pair.col;

            if(root != null){
                if(!map.containsKey(column)){
                    map.put(column, new ArrayList<Integer>());
                }

                map.get(column).add(root.val);
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));

                if(column < minColumn){
                    minColumn = column;
                }

                if(column > maxColumn){
                    maxColumn = column + 1;
                }

            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        for(int i = minColumn; i <= maxColumn; i++){
            res.add(map.get(i));
        }

        return res;
    }
}
