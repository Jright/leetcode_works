package No1301_1350;

import Data_Structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No1302_DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.val;
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(0, root));

        int max = 0;

        int sum = 0;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.getLevel();

            if(level > max){
                max = level;
                sum = 0;
            }

            TreeNode node = pair.getNode();
            sum += node.val;

            if(node.left != null){
                queue.offer(new Pair(level + 1, node.left));
            }

            if(node.right != null){
                queue.offer(new Pair(level + 1, node.right));
            }

        }

        return sum;
    }

    class Pair{
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }

        public int getLevel() {
            return level;
        }

        public TreeNode getNode() {
            return node;
        }
    }
}
