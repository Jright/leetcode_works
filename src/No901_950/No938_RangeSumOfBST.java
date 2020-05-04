package No901_950;

import Data_Structures.TreeNode;

public class No938_RangeSumOfBST {

    int left;
    int right;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }

        left = L;
        right = R;
        return helper(root);
    }

    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.val < left){
            return helper(node.right);
        }

        if(node.val > right){
            return helper(node.left);
        }

        return node.val + helper(node.left) + helper(node.right);
    }
}
