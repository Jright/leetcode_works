package No1301_1350;

import java.util.*;

public class No1345_JumpGameIV {
    public int minJumps(int[] arr) {
        if(arr.length == 1){
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int index = 0; index < arr.length; index++){
            graph.computeIfAbsent(arr[index], v -> new LinkedList<>()).add(index);
        }

        List<Integer> curr = new LinkedList<>();
        curr.add(0);
        Set<Integer> visited = new HashSet<>();
        int step = 0;

        while(!curr.isEmpty()){
            List<Integer> next = new LinkedList<>();

            for(int node : curr){
                if(node == arr.length - 1){
                    return step;
                }

                for(int child : graph.get(arr[node])){
                    if(!visited.contains(child)){
                        visited.add(child);
                        next.add(child);
                    }
                }

                graph.get(arr[node]).clear();

                if(node + 1 < arr.length && !visited.contains(node + 1)){
                    visited.add(node + 1);
                    next.add(node + 1);
                }

                if(node - 1 >= 0 && !visited.contains(node - 1)){
                    visited.add(node - 1);
                    next.add(node - 1);
                }
            }
            curr = next;
            step++;
        }

        return -1;
    }
}
