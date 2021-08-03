package No301_350;

import Data_Structures.TreeNode;

public class No333_LargestBSTSubTree {

    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] ans = findLargestBST(root);
        return ans[2];
    }

    private int[] findLargestBST(TreeNode node){
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] leftValue = findLargestBST(node.left);
        int[] rightValue = findLargestBST(node.right);

        if((node.val > leftValue[1]) && (node.val < rightValue[0])){
            return new int[]{Math.min(node.val, leftValue[0]), Math.max(node.val, rightValue[1]),
                    leftValue[2] + rightValue[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftValue[2], rightValue[2])};
        }
    }
}
