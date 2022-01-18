package No1101_1150;

import java.util.*;

public class No1136_ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        if(n == 1){
            return 1;
        }

        List<HashSet<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];
        for(int index = 0; index <= n; index++){
            graph.add(new HashSet<>());
        }

        for(int[] relation : relations){
            graph.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }

        int studiedCount = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        for(int index = 1; index <= n; index++){
            if(indegree[index] == 0){
                queue.offer(index);
            }
        }

        int semester = 0;

        while(!queue.isEmpty()){
            semester++;
            Queue<Integer> newQ = new ArrayDeque<>();
            for(int course : queue){
                studiedCount++;
                for(int endNode : graph.get(course)){
                    indegree[endNode]--;
                    if(indegree[endNode] == 0){
                        newQ.offer(endNode);
                    }
                }
            }
            queue = newQ;
        }

        return studiedCount == n ? semester : -1;
    }
}
