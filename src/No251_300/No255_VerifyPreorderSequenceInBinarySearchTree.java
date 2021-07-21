package No251_300;

public class No255_VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {

        if(preorder == null || preorder.length == 0){
            return false;
        }

        if(preorder.length <= 2){
            return true;
        }

        int low = Integer.MIN_VALUE;
        int index = -1;
        for (int item : preorder) {
            if (item < low){
                return false;
            }
            while (index >= 0 && item > preorder[index]){
                low = preorder[index];
                index--;
            }
            index++;
            preorder[index] = item;
        }
        return true;

    }
}
