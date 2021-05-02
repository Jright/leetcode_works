package No151_200;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No173_BinarySearchTreeIterator {

    LinkedList<TreeNode> inOrderNodeList;

    public No173_BinarySearchTreeIterator(TreeNode root) {
        inOrderNodeList = new LinkedList<>();
        if(root == null){
            return;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode runner = root;
        while(runner != null || !stack.isEmpty()){
            while(runner != null){
                stack.push(runner);
                runner = runner.left;
            }
            TreeNode pop = stack.pop();
            inOrderNodeList.add(pop);
            runner = pop.right;
        }
    }

    public int next() {
        return inOrderNodeList.removeFirst().val;
    }

    public boolean hasNext() {
        return !(inOrderNodeList.size() == 0);
    }

}
