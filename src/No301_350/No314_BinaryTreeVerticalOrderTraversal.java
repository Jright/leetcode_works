package No301_350;

import Data_Structures.TreeNode;

import java.util.*;

public class No314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Map<TreeNode, Integer>> queue = new ArrayDeque<>();

        int column = 0;
        Map<TreeNode, Integer> nodeColumnMap = new HashMap<>();
        nodeColumnMap.put(root, column);
        queue.offer(nodeColumnMap);
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Map<TreeNode, Integer> pair = queue.poll();
            root = (TreeNode) pair.keySet().toArray()[0];
            column = (int) pair.values().toArray()[0];

            if(root != null){
                if(!map.containsKey(column)){
                    map.put(column, new ArrayList<Integer>());
                }

                map.get(column).add(root.val);
                Map<TreeNode, Integer> leftMap = new HashMap<>();
                leftMap.put(root.left, column - 1);

                Map<TreeNode, Integer> rightMap = new HashMap<>();
                rightMap.put(root.right, column + 1);
                queue.offer(leftMap);
                queue.offer(rightMap);

                if(column < minColumn){
                    minColumn = column;
                }

                if(column > maxColumn){
                    maxColumn = column;
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
