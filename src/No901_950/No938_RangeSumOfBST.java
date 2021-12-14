package No901_950;

import Data_Structures.TreeNode;

public class No938_RangeSumOfBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }

    private int helper(TreeNode node, int left, int right){

        if(node == null){
            return 0;
        }

        if(node.val >= left && node.val <= right){
            sum += node.val;
            helper(node.left, left, right);
            helper(node.right, left, right);
        }else if(node.val < left){
            helper(node.right, left, right);
        }else if(node.val > right){
            helper(node.left, left, right);
        }

        return sum;
    }
}
