import Data_Structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        String current = String.valueOf(root.val);
        dfs(result, current, root);
        return result;
    }

    private void dfs(List<String> result, String current, TreeNode node){
        if(node.left == null && node.right == null){
            result.add(current);
            return;
        }

        if(node.left != null){
            dfs(result, current + "->" + node.val, node.left);
        }

        if(node.right != null){
            dfs(result, current + "->" + node.val, node.right);
        }
    }

}
