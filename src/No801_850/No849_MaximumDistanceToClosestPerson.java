package No801_850;

import java.util.ArrayDeque;
import java.util.Queue;

public class No849_MaximumDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] distArr = new int[n];
        Queue<Integer> seatQ = new ArrayDeque<>();

        for(int index = 0; index < n; index++){
            if(seats[index] == 1){
                distArr[index] = 0;
                seatQ.offer(index);
            }else{
                distArr[index] = -1;
            }
        }


        while(!seatQ.isEmpty()){
            int index = seatQ.poll();
            if(index - 1 >= 0){
                if(distArr[index - 1] == -1){
                    seatQ.offer(index - 1);
                    distArr[index - 1] = distArr[index] + 1;
                }
            }

            if(index + 1 < n){
                if(distArr[index + 1] == -1){
                    seatQ.offer(index + 1);
                    distArr[index + 1] = distArr[index] + 1;
                }
            }
        }

        int max = -1;
        for(int index = 0; index < n; index++){
            max = Math.max(distArr[index], max);
        }

        return max;
    }
}
