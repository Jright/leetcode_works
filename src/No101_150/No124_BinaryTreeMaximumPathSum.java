package No101_150;

import Data_Structures.TreeNode;

public class No124_BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node){
        if(node == null){
            return 0;
        }

        // the greatest value we can get from the left sub-tree
        int leftGain = Math.max(maxGain(node.left), 0);

        // the greatest value we can get from the right sub-tree
        int rightGain = Math.max(maxGain(node.right), 0);

        // the value of that path which to make this current node as
        // the 'root'. We get this choice's total value, and compare
        // with the current stored maxSum, to decide whether if
        // we should continue this current path, or to make this
        // current node as the new root node of the new selected
        // path.
        int priceNewPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);

        // the maxGain of continuing this current path.
        return node.val + Math.max(leftGain, rightGain);
    }


}
