package No1301_1350;

import java.util.*;

public class No1345_JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 0;
        }

        if(n == 2 || arr[0] == arr[n - 1]){
            return 1;
        }

        if(arr[0] == arr[n - 2]){
            return 2;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();

        for(int index = 0; index < n; index++){
            if(!indexMap.containsKey(arr[index])){
                indexMap.put(arr[index], new ArrayList<>());
            }
            indexMap.get(arr[index]).add(index);
        }

        queue.add(n - 1);
        boolean[] seen = new boolean[n];

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int index = 0; index < size; index++){
                int state = queue.poll();
                if(state == 0){
                    return level;
                }

                if(state + 1 < n && !seen[state + 1]){
                    seen[state + 1] = true;
                    queue.add(state + 1);
                }

                if (state - 1 >= 0 && !seen[state - 1]) {
                    seen[state - 1] = true;
                    if (state - 1 == 0){
                        return level + 1;
                    }
                    queue.add(state - 1);
                }

                List<Integer> same = indexMap.get(arr[state]);
                for (int i : same) {
                    if (i == state || seen[i]) continue;
                    seen[i] = true;
                    if (i == 0) return level + 1;
                    queue.add(i);
                }
            }
            level++;
        }
        return -1;
    }
}
