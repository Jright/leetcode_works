package No851_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No886_PossibleBipartitions {

    List<Integer>[] graph;
    Map<Integer, Integer> colorMap;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }


        for(int[] edge: dislikes){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        colorMap = new HashMap<>();

        for(int i = 1; i <= N; i++){
            if(!colorMap.containsKey(i) && !dfs(i, 0)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int c){
        if(colorMap.containsKey(node)){
            return colorMap.get(node) == c;
        }

        colorMap.put(node, c);

        for(int i = 0; i < graph[node].size(); i++){
            if(!dfs(graph[node].get(i), c ^ 1)){
                return false;
            }
        }
        return true;
    }

}
