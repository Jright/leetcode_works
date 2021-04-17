package No101_150;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No145_BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();

        TreeNode node = root;
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode popNode = stack.pop();
            result.addFirst(popNode.val);
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
