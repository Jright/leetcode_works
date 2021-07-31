package No251_300;

import Data_Structures.TreeNode;

public class No298_BinaryTreeLongestConsecutiveSequence {

    private int max = 0;

    public int longestConsecutive(TreeNode root) {

        if(root == null){
            return max;
        }

        DFS(root, null, 0);

        return max;
    }

    private void DFS(TreeNode node, TreeNode parent, int length){
        if(node == null){
            return;
        }

        length = (parent != null && node.val == parent.val + 1) ? length + 1 : 1;

        max = Math.max(max, length);

        DFS(node.left, node, length);
        DFS(node.right, node, length);
    }
}
