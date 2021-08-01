package No1401_1450;

import Data_Structures.TreeNode;

public class No1448_CountGoodNodesInBinaryTree {

    int res = 0;

    public int goodNodes(TreeNode root) {
        if(root == null){
            return res;
        }

        res++;
        DFS(root.left, root.val);
        DFS(root.right, root.val);
        return res;
    }

    private void DFS(TreeNode node, int limit){
        if(node == null){
            return;
        }

        if(node.val >= limit){
            if(node.left != null || node.right != null){
                limit = node.val;
            }
            res++;
        }

        if(node.left != null){
            DFS(node.left, limit);
        }

        if(node.right != null){
            DFS(node.right, limit);
        }
    }
}
