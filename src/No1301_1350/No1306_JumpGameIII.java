package No1301_1350;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class No1306_JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0){
            return true;
        }

        boolean[] visited = new boolean[arr.length];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int currIndex = queue.poll();

            if(currIndex < 0 || currIndex > arr.length - 1){
                continue;
            }

            if(arr[currIndex] == 0){
                return true;
            }

            int leftJump = currIndex - arr[currIndex];
            int rightJump = currIndex + arr[currIndex];

            if((leftJump >= 0 && arr[leftJump] == 0) ||
                    (rightJump <= arr.length - 1) && (arr[rightJump] == 0)){
                return true;
            }

            if(leftJump >= 0 && !visited[leftJump]){
                queue.offer(leftJump);
                visited[leftJump] = true;
            }

            if(rightJump <= arr.length - 1 && !visited[rightJump]){
                queue.offer(rightJump);
                visited[rightJump] = true;
            }
        }
        return false;
    }
}
