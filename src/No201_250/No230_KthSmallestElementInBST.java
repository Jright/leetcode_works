package No201_250;

import Data_Structures.TreeNode;

import java.util.*;

public class No230_KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> inorderList = new ArrayList<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            inorderList.add(node.val);
            if(inorderList.size() == k){
                return inorderList.get(inorderList.size() - 1);
            }
            node = node.right;
        }

        if(k >= 1 && k <= inorderList.size()){
            return inorderList.get(k - 1);
        }else{
            return Integer.MIN_VALUE;
        }
    }
}
