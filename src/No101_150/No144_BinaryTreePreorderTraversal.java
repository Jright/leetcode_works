package No101_150;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            result.add(popNode.val);
            if(popNode.left != null){
                stack.push(popNode.left);
            }
            if(popNode.right != null){
                stack.push(popNode.right);
            }
        }
        return result;
    }
}
