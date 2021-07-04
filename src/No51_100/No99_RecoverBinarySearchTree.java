package No51_100;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No99_RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root);

        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        return;
    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }

        inorder(node.left);

        if(first == null && node.val < prev.val){
            first = prev;
        }

        if(first != null && node.val < prev.val){
            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}
