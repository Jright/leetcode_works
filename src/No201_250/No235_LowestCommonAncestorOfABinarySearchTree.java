package No201_250;

import Data_Structures.TreeNode;

public class No235_LowestCommonAncestorOfABinarySearchTree {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        int small = Math.min(p.val, q.val);
        int big = Math.max(p.val, q.val);
        if(root.val > small && root.val < big){
            return root;
        }else if(root.val < small){
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.val > big){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val == small || root.val == big){
            return root;
        }
        return res;
    }
}
