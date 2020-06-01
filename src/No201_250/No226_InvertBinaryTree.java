package No201_250;

import Data_Structures.TreeNode;

public class No226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode result = new TreeNode();
        result.val = root.val;
        result.left = helper(root.right);
        result.right = helper(root.left);
        return result;

    }

    private TreeNode helper(TreeNode origin){
        if(origin == null){
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = origin.val;

        node.left = helper(origin.right);
        node.right = helper(origin.left);
        return node;
    }
}
