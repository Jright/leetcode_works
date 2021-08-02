package No851_900;

import Data_Structures.TreeNode;

import java.util.*;

public class No863_AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> map;
    int K;
    List<Integer> ans = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if(root == null || target == null || k < 0){
            return ans;
        }

        K = k;

        map = new HashMap<>();
        DFS(root, null);

        visited.add(target);

        BFS(target, 0);
        return ans;
    }

    private void DFS(TreeNode node, TreeNode parent){
        if(node != null){
            map.put(node, parent);
            DFS(node.left, node);
            DFS(node.right, node);
        }
    }

    private void BFS(TreeNode node, int dist){
        if(dist == K){
            ans.add(node.val);
            return;
        }

        if(node.left != null && !visited.contains(node.left)){
            visited.add(node.left);
            BFS(node.left, dist + 1);
        }

        if(node.right != null && !visited.contains(node.right)){
            visited.add(node.right);
            BFS(node.right, dist + 1);
        }

        if(map.get(node) != null && !visited.contains(map.get(node))){
            visited.add(map.get(node));
            BFS(map.get(node), dist + 1);
        }
    }
}
