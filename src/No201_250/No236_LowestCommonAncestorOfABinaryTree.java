package No201_250;

import Data_Structures.TreeNode;

public class No236_LowestCommonAncestorOfABinaryTree {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        traverseTree(root, p, q);

        return ans;

    }

    private boolean traverseTree(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }

        int left = traverseTree(node.left, p, q) ? 1 : 0;
        int right = traverseTree(node.right, p, q) ? 1 : 0;

        int mid = (node == p) || (node == q) ? 1 : 0;

        if(left + right + mid >= 2){
            ans = node;
        }

        return (left + right + mid) > 0;
    }
}
