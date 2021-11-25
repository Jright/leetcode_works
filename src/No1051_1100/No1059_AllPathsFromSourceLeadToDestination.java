package No1051_1100;

import java.util.ArrayList;
import java.util.List;

public class No1059_AllPathsFromSourceLeadToDestination {

    private static final int UNTOUCHED = 0;
    private static final int PROCESSING = 1;
    private static final int PROCESSED = 2;

    private int[] states;
    private List<Integer>[] routeMap;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        states = new int[n];
        routeMap = new ArrayList[n];
        if(edges.length == 0){
            return source == destination;
        }

        for(int[] edge : edges){
            if(routeMap[edge[0]] == null){
                routeMap[edge[0]] = new ArrayList<Integer>();
            }
            routeMap[edge[0]].add(edge[1]);
        }

        return dfs(source, routeMap, states, destination);
    }

    private boolean dfs(int curr, List<Integer>[] routeMap, int[] states, int destination){
        if(states[curr] != UNTOUCHED){
            return states[curr] == PROCESSED;
        }

        if(routeMap[curr] == null){
            if(curr != destination){
                return false;
            }else{
                return true;
            }
        }

        List<Integer> nextList = routeMap[curr];

        states[curr] = PROCESSING;
        for(Integer next : nextList){
            if(!dfs(next, routeMap, states, destination)){
                return false;
            }
        }
        states[curr] = PROCESSED;

        return true;
    }
}
