package No201_250;

import Data_Structures.TreeNode;

public class No222_CountCompleteTreeNodes {

    int result = 0;

    public int countNodes(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode node){
        if(node == null){
            return;
        }

        result++;

        helper(node.left);
        helper(node.right);
    }

}
