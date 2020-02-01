package No101_150;

import Data_Structures.TreeNode;

public class No110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int maxLeft = maxDepth(root.left, 2);
        int maxRight = maxDepth(root.right, 2);

        if (Math.abs(maxLeft - maxRight) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private int maxDepth(TreeNode node, int level) {
        if (node == null) {
            return level - 1;
        }

        int maxLeft = maxDepth(node.left, level + 1);
        int maxRight = maxDepth(node.right, level + 1);

        return Math.max(maxLeft, maxRight);
    }

}
