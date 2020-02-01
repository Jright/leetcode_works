package No101_150;

import Data_Structures.TreeNode;

public class No101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return checkSons(root, root);
    }

    private boolean checkSons(TreeNode left, TreeNode right){
        if(left == null && right == null) {
            return true;
        }else if(left == null || right == null){
            return false;
        }

        return left.val == right.val && checkSons(left.left, right.right) &&
                checkSons(left.right, right.left);
    }

}
