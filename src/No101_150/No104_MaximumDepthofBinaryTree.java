package No101_150;

public class No104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int level){
        if(node == null){
            return --level;
        }
        level++;
        return Math.max(maxDepth(node.left, level), maxDepth(node.right, level));
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
