package No251_300;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No285_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorder(root, p);
    }

    private TreeNode inorder(TreeNode node, TreeNode p){

        if(node == null){
            return null;
        }

        boolean foundP = false;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if(foundP){
                return node;
            }

            if(node.val == p.val){
                foundP = true;
            }

            node = node.right;
        }
        return null;
    }
}
