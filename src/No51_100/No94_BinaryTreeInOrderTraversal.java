package No51_100;

import Data_Structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No94_BinaryTreeInOrderTraversal {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }

        helper(ans, root);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode root){
        if(root != null){
            if(root.left != null){
                helper(ans, root.left);
            }
            ans.add(root.val);
            if(root.right != null){
                helper(ans, root.right);
            }
        }
    }
}
