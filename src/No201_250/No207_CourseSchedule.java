package No201_250;

import java.util.LinkedList;
import java.util.Queue;

public class No207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites.length == 0){
            return true;
        }

        int canFinish = 0;
        int[] nums= new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            nums[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int j = 0; j < numCourses; j++){
            if(nums[j] == 0){
                queue.add(j);
            }
        }

        canFinish = queue.size();

        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int k = 0; k < prerequisites.length; k++){
                if(prerequisites[k][1] == course){
                    nums[prerequisites[k][0]]--;
                    if(nums[prerequisites[k][0]] == 0){
                        queue.add(prerequisites[k][0]);
                        canFinish++;
                    }
                }
            }
        }

        return (canFinish == numCourses);
    }
}
