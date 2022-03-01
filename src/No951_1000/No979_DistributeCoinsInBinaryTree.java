package No951_1000;

import Data_Structures.TreeNode;

public class No979_DistributeCoinsInBinaryTree {
    int ans = 0;
    public int No979_DistributeCoinsInBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        ans += Math.abs(l) + Math.abs(r);
        return node.val + l + r - 1;
    }
}
