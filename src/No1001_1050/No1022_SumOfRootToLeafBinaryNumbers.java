package No1001_1050;

import Data_Structures.TreeNode;

public class No1022_SumOfRootToLeafBinaryNumbers {
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int curr){
        if(node != null){
            curr = (curr << 1) | node.val;
            if(node.left == null && node.right == null){
                res += curr;
            }
            helper(node.left, curr);
            helper(node.right, curr);
        }
    }
}
