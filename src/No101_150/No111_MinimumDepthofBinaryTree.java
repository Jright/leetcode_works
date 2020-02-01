package No101_150;

import Data_Structures.TreeNode;

public class No111_MinimumDepthofBinaryTree {


    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left == null){
            return 1 + minDepth(root.right);
        }

        if(root.right == null){
            return 1 + minDepth(root.left);
        }

        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }



}
