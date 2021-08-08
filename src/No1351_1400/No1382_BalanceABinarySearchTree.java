package No1351_1400;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No1382_BalanceABinarySearchTree {
    List<TreeNode> inorderList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            inorderList.add(new TreeNode(root.val));
            root = root.right;
        }

        int left = 0;
        int right = inorderList.size() - 1;
        TreeNode ans = buildTreeHelper(left, right);
        return ans;
    }

    private TreeNode buildTreeHelper(int left, int right){
        if(left > right){
            return null;
        }

        int newRootIndex = left + (right - left) / 2;
        TreeNode node = inorderList.get(newRootIndex);
        node.left = buildTreeHelper(left, newRootIndex - 1);
        node.right = buildTreeHelper(newRootIndex + 1, right);
        return node;
    }
}
