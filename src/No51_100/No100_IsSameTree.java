package No51_100;

import Data_Structures.TreeNode;

public class No100_IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
