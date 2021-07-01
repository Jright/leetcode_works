package No351_400;

import Data_Structures.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No366_FindLeavesOfBinaryTree {

    List<List<Integer>> result = new ArrayList<>();
    Set<TreeNode> leafSet = new HashSet<>();

    public List<List<Integer>> findLeaves(TreeNode root) {

        if (root == null) {
            return result;
        }

        while (!leafSet.contains(root)) {
            List<Integer> leafList = new ArrayList<>();
            helper(root, leafList);

            result.add(leafList);
        }
        return result;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void helper(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        if(leafSet.contains(node)){
            return;
        }

        if(node.right != null && leafSet.contains(node.right)){
            node.right = null;
        }

        if(node.left != null && leafSet.contains(node.left)){
            node.left = null;
        }

        if (isLeafNode(node)) {
            list.add(node.val);
            leafSet.add(node);
            node = null;
        } else {
            helper(node.left, list);
            helper(node.right, list);
        }
    }
}
