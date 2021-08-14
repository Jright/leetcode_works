package No201_250;

import java.util.*;

public class No210_CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] indegree = new int[numCourses];

        int[] topologicalOrder = new int[numCourses];

        for(int index = 0; index < prerequisites.length; index++){
            int src = prerequisites[index][1];
            int dest = prerequisites[index][0];

            List<Integer> list = map.getOrDefault(src, new ArrayList<>());

            list.add(dest);

            map.put(src, list);
            indegree[dest]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for(int index = 0; index < numCourses; index++){
            if(indegree[index] == 0){
                queue.offer(index);
            }
        }

        int topoIndex = 0;

        while(!queue.isEmpty()){
            int num = queue.poll();

            topologicalOrder[topoIndex++] = num;

            if(map.containsKey(num)){
                for(int adj: map.get(num)){
                    indegree[adj]--;

                    if(indegree[adj] == 0){
                        queue.offer(adj);
                    }
                }
            }
        }

        if(topoIndex == numCourses){
            return topologicalOrder;
        }

        return new int[0];
    }
}
