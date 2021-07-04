package No101_150;

import Data_Structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class No106_ConstructBinaryTreefromPostorderandInorderTraversal {

    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }

        int root_val = postorder[postIndex];
        TreeNode root = new TreeNode(root_val);

        int index = indexMap.get(root_val);

        postIndex--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        postIndex = postorder.length - 1;

        for (int index = 0; index < inorder.length; index++) {
            indexMap.put(inorder[index], index);
        }

        return helper(0, inorder.length - 1);
    }

}
