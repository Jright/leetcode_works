package No1951_2000;

import java.util.*;

public class No1971_FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {

        if(start == end){
            return true;
        }

        Set<Integer> visited = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int index = 0; index < edges.length; index++){
            int[] edge = edges[index];
            if(!map.containsKey(edge[0])){
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            }else{
                List<Integer> list = map.get(edge[0]);
                list.add(edge[1]);
                map.put(edge[0], list);
            }

            if(!map.containsKey(edge[1])){
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                map.put(edge[1], list);
            }else{
                List<Integer> list = map.get(edge[1]);
                list.add(edge[0]);
                map.put(edge[1], list);
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(curr == end){
                return true;
            }

            visited.add(curr);
            List<Integer> list = map.get(curr);
            if(list == null){
                continue;
            }

            for(int index = 0; index < list.size(); index++){
                if(visited.contains(list.get(index))){
                    continue;
                }
                stack.push(list.get(index));
            }
        }
        return false;
    }
}
