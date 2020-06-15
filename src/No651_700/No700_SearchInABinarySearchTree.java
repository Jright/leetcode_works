package No651_700;

import Data_Structures.TreeNode;

public class No700_SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        }

        if(root.val < val){
            if(root.right == null){
                return null;
            }else{
                return searchBST(root.right, val);
            }
        }

        if(root.val > val){
            if(root.left == null){
                return null;
            }else{
                return searchBST(root.left, val);
            }
        }

        return root;
    }
}
