package No1001_1050;

import Data_Structures.TreeNode;

public class No1026_MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }

        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int maxSoFar, int minSoFar){
        if(node == null){
            return maxSoFar - minSoFar;
        }

        maxSoFar = Math.max(node.val, maxSoFar);
        minSoFar = Math.min(node.val, minSoFar);

        int left = helper(node.left, maxSoFar, minSoFar);
        int right = helper(node.right, maxSoFar, minSoFar);

        return Math.max(left, right);
    }
}
