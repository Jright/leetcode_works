package No101_150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No107_BinaryTreeLevelTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> dfs = dfs(root, new ArrayList<List<Integer>>(), 1);
        Collections.reverse(dfs);
        return dfs;
    }

    private List<List<Integer>> dfs(TreeNode node, List<List<Integer>> lists, int level){
        if(node == null){
            return lists;
        }



        if(lists.size() < level){
            lists.add(new ArrayList<Integer>());
        }

        lists.get(level - 1).add(node.val);
        dfs(node.left, lists, level + 1);
        dfs(node.right, lists, level + 1);
        return lists;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
