package No251_300;

import Data_Structures.TreeNode;

import java.util.*;

public class No272_ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> inorderList = inorder(root);

        if(inorderList.size() == 0){
            return inorderList;
        }

        if(inorderList.get(0) > target){
            return inorderList.subList(0, k);
        }

        if(inorderList.get(inorderList.size() - 1) < target){
            return inorderList.subList(inorderList.size() - k ,inorderList.size());
        }

        Collections.sort(inorderList, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });

        return inorderList.subList(0, k);

    }

    private List<Integer> inorder(TreeNode node){
        List<Integer> list = new ArrayList<>();

        if(node == null){
            return list;
        }

        TreeNode temp = node;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }

        return list;
    }
}
