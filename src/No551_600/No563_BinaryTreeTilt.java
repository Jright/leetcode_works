package No551_600;

import Data_Structures.TreeNode;

public class No563_BinaryTreeTilt {

    int sum = 0;

    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }

        helper(root);

        return sum;
    }

    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        sum += Math.abs(left - right);

        return left + right + node.val;
    }
}
