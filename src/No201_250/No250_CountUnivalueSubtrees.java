package No201_250;

import Data_Structures.TreeNode;

public class No250_CountUnivalueSubtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }

        DFS(root, root.val);
        return count;
    }

    private boolean DFS(TreeNode node, int parentValue){
        if(node == null){
            return true;
        }

        if(!DFS(node.left, node.val) | !DFS(node.right, node.val)){
            return false;
        }

        count++;

        return node.val == parentValue;
    }
}
