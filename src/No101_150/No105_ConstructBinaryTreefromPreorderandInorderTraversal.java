package No101_150;

import Data_Structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class No105_ConstructBinaryTreefromPreorderandInorderTraversal {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        for(int index = 0; index < n; index++){
            indexMap.put(inorder[index], index);
        }

        return buildTreeWithIndexes(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    private TreeNode buildTreeWithIndexes(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                                          int inorder_left, int inorder_right){
        if (preorder_left > preorder_right) {
            return null;
        }

        int preorder_root = preorder_left;

        int inorder_root = indexMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_left]);

        int size_left_subtrees = inorder_root - inorder_left;

        root.left = buildTreeWithIndexes(preorder, inorder, preorder_left + 1,
                preorder_left + size_left_subtrees, inorder_left, inorder_root - 1);

        root.right = buildTreeWithIndexes(preorder, inorder, preorder_left + size_left_subtrees + 1,
                preorder_right, inorder_root + 1, inorder_right);

        return root;
    }

}
