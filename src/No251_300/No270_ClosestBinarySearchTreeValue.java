package No251_300;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        if(root.left == null && root.right == null){
            return root.val;
        }

        TreeNode small = new TreeNode(Integer.MIN_VALUE);
        TreeNode big = new TreeNode(Integer.MAX_VALUE);

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if(node.val == target){
                return node.val;
            }

            if(node.val > small.val && node.val < target){
                small.val = node.val;
            }

            if(node.val < big.val && node.val > target){
                big.val = node.val;
                break;
            }

            node = node.right;
        }

        double smallDiff = target - small.val;
        double bigDiff = big.val - target;

        return bigDiff < smallDiff ? big.val : small.val;
    }
}
