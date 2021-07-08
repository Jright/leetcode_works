package No101_150;

import Data_Structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No113_PathSumII {


    List<List<Integer>> res = new ArrayList<>();
    int globalTargetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }

        this.globalTargetSum = targetSum;
        helper(root, new LinkedList<Integer>(), 0);
        return res;
    }

    private void helper(TreeNode node, LinkedList<Integer> list, int sum){
        if(node == null){
            return;
        }

        sum += node.val;
        list.addLast(node.val);

        if(node.left == null && node.right == null){
            if(sum == this.globalTargetSum){
                res.add((List)list.clone());
                return;
            }
        }

        if(node.left != null){
            helper(node.left, list, sum);
            list.removeLast();
        }

        if(node.right != null){
            helper(node.right, list, sum);
            list.removeLast();
        }
    }
}
