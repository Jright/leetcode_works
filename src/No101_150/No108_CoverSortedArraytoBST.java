package No101_150;

import Data_Structures.TreeNode;

public class No108_CoverSortedArraytoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        return dfs(nums, left, right);
    }

    private TreeNode dfs(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid - 1);
        node.right = dfs(nums, mid + 1, right);
        return node;

    }

}
