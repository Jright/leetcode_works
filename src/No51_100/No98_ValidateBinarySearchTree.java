package No51_100;

import Data_Structures.TreeNode;

public class No98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left != null && root.right != null){
            if(root.val <= root.left.val){
                return false;
            }

            if(root.val >= root.right.val){
                return false;
            }

            return isValidBST(root.left) && isValidBST(root.right);
        }

        if(root.left != null){
            if(root.val <= root.left.val){
                return false;
            }
            return isValidBST(root.left);
        }

        if(root.right != null){
            if(root.val >= root.right.val){
                return false;
            }
            return isValidBST(root.right);
        }

        return true;
    }
}
