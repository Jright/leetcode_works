package No101_150;

import Data_Structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No114_FlattenBinaryTreeIntoLinkedList {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            return;
        }

        List<Integer> list = new ArrayList<>();
        fillList(list, root);

        TreeNode node = root;

        for(int index = 1; index < list.size(); index++){
            node.right = new TreeNode(list.get(index));
            node.left = null;
            node = node.right;
        }

        return;
    }

    private void fillList(List<Integer> list, TreeNode node){

        if(node == null){
            return;
        }

        list.add(node.val);

        fillList(list, node.left);
        fillList(list, node.right);
    }
}
