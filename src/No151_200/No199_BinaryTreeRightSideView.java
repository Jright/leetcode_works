package No151_200;

import Data_Structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        if(root == null){
            return resList;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            int levelLength = stack.size();

            for(int index = 0; index < levelLength; index++){
                TreeNode node = stack.poll();

                if(index == levelLength - 1){
                    resList.add(node.val);
                }

                if(node.left != null){
                    stack.offer(node.left);
                }

                if(node.right != null){
                    stack.offer(node.right);
                }
            }
        }

        return resList;
    }
}
