package No701_750;

import Data_Structures.TreeNode;

public class No701_InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode insertNode = new TreeNode(val);
        helper(root, insertNode);
        return root;
    }

    private void helper(TreeNode node, TreeNode insertNode){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            if(node.val < insertNode.val){
                node.right = insertNode;
            }else{
                node.left = insertNode;
            }
            return;
        }

        if(node.left == null){
            if(node.val > insertNode.val){
                node.left = insertNode;
                return;
            }
        }

        if(node.right == null){
            if(node.val < insertNode.val){
                node.right = insertNode;
                return;
            }
        }

        if(node.val > insertNode.val){
            helper(node.left, insertNode);
        }else{
            helper(node.right, insertNode);
        }
    }
}
