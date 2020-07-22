package No101_150;

import Data_Structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        LinkedList<Integer> levelList = new LinkedList<>();
        boolean isLeftOrder = true;

        while(nodeQueue.size() > 0){
            TreeNode curNode = nodeQueue.pollFirst();
            if(curNode != null){
                if(isLeftOrder){
                    levelList.addLast(curNode.val);
                }else{
                    levelList.addFirst(curNode.val);
                }

                if(curNode.left != null){
                    nodeQueue.addLast(curNode.left);
                }

                if(curNode.right != null){
                    nodeQueue.addLast(curNode.right);
                }

            }else{
                results.add(levelList);
                levelList = new LinkedList<>();
                if(nodeQueue.size() > 0){
                    nodeQueue.addLast(null);
                }
                isLeftOrder = !isLeftOrder;
            }
        }

        return results;
    }
}
