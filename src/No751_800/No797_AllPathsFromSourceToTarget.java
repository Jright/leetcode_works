package No751_800;

import java.util.ArrayList;
import java.util.List;

public class No797_AllPathsFromSourceToTarget {

    List<List<Integer>> res = new ArrayList<>();

    int target;
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph.length == 0){
            return res;
        }

        this.target = graph.length - 1;
        this.graph = graph;
        int source = 0;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        this.backtrack(source, path);
        return this.res;

    }

    private void backtrack(int currentNode, List<Integer> path){
        if(currentNode == target){
            // Pay attention to here. Needs to create a new instance of this path variable.
            res.add(new ArrayList<>(path));
            return;
        }

        for(int nextNode: this.graph[currentNode]){
            path.add(nextNode);
            this.backtrack(nextNode, path);
            path.remove(path.size() - 1);
        }
    }


}
