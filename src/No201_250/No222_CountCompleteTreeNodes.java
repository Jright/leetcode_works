package No201_250;

import Data_Structures.TreeNode;

public class No222_CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int result = 0;
        int height = countHeight(root);
        if(height <= 1){
            return height;
        }

        result += (int) Math.pow(2, (height - 1)) - 1;

        int left = 0;
        int right = (int) Math.pow(2, (height - 1)) - 1;
        int pivot;
        while(left <= right){
            pivot = left + (right - left) / 2;
            if(exists(root, pivot, height)){
                left = pivot + 1;
            }else{
                right = pivot - 1;
            }
        }

        result += left;
        return result;
    }

    private int countHeight(TreeNode node){
        int result = 0;

        while(node != null){
            result++;
            node = node.left;
        }

        return result;
    }

    private boolean exists(TreeNode node, int index, int height){
        int left = 0;
        int right = (int) Math.pow(2, (height - 1)) - 1;
        int pivot;

        for(int i = 0; i < (height - 1); i++){
            pivot = left + (right - left) / 2;
            if(index <= pivot){
                node = node.left;
                right = pivot;
            }else{
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

}
