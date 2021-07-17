package No151_200;

import Data_Structures.TreeNode;

public class No156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }

        TreeNode prev = null;
        TreeNode next = null;
        TreeNode curr = root;
        TreeNode temp = null;

        while(curr != null){
            next = curr.left;

            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
