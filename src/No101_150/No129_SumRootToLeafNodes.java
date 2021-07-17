package No101_150;

import Data_Structures.TreeNode;

public class No129_SumRootToLeafNodes {

    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }


        helper(root, 0);

        return totalSum;

    }

    private void helper(TreeNode node, int sum){
        if(node == null){
            return;
        }

        if(isLeafNode(node)){
            totalSum = totalSum + sum * 10 + node.val;
            return;
        }

        helper(node.left, sum * 10 + node.val);
        helper(node.right, sum * 10 + node.val);

    }


    private boolean isLeafNode(TreeNode node){
        if(node == null){
            return false;
        }

        if(node.left == null && node.right == null){
            return true;
        }

        return false;
    }
}
