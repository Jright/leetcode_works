package No501_550;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No545_BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        if(!isLeafNode(root)){
            res.add(root.val);
        }

        TreeNode node = root.left;

        while(node != null){
            if(!isLeafNode(node)){
                res.add(node.val);
            }

            if(node.left != null){
                node = node.left;
            }else{
                node = node.right;
            }
        }

        addLeaves(res, root);

        Deque<Integer> stack = new ArrayDeque<>();
        node = root.right;

        while(node != null){
            if(!isLeafNode(node)){
                stack.push(node.val);
            }

            if(node.right != null){
                node = node.right;
            }else{
                node = node.left;
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;

    }

    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

    private void addLeaves(List<Integer> res, TreeNode root){
        if(isLeafNode(root)){
            res.add(root.val);
        }else{
            if(root.left != null){
                addLeaves(res, root.left);
            }

            if(root.right != null){
                addLeaves(res, root.right);
            }
        }
    }
}
