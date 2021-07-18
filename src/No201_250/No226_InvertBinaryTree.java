package No201_250;

import Data_Structures.TreeNode;

public class No226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        helper(node);
        return root;
    }

    private void helper(TreeNode node){
        if(node == null){
            return;
        }

        if(node.left != null){
            helper(node.left);
        }

        if(node.right != null){
            helper(node.right);
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
