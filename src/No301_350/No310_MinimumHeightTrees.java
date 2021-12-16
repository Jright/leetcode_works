package No301_350;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No310_MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2){
            ArrayList<Integer> centroids = new ArrayList<>();
            for(int index = 0; index < n; index++){
                centroids.add(index);
            }
            return centroids;
        }

        List<Set<Integer>> neighbors = new ArrayList<>();

        for(int index = 0; index < n; index++){
            neighbors.add(new HashSet<Integer>());
        }

        for(int[] edge : edges){
            Integer start = edge[0];
            Integer end = edge[1];

            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        List<Integer> leaves = new ArrayList<>();

        for(int index = 0; index < n; index++){
            if(neighbors.get(index).size() == 1){
                leaves.add(index);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for(Integer leaf: leaves){
                Integer neighbor = neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if(neighbors.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
