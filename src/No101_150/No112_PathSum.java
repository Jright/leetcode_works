package No101_150;

import Data_Structures.TreeNode;

public class No112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                return true;
            }else{
                return false;
            }
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}
