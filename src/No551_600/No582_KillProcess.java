package No551_600;

import java.util.*;

public class No582_KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for(; index < pid.size(); index++){
            int parent = ppid.get(index);

            if(!map.containsKey(parent)){
                map.put(parent, new ArrayList<>());
            }

            int child = pid.get(index);
            map.get(parent).add(child);
        }

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);

        while(!queue.isEmpty()){
            int item = queue.poll();
            ans.add(item);
            List<Integer> childList = map.get(item);
            if(childList != null){
                queue.addAll(childList);
            }
        }

        return ans;
    }
}
