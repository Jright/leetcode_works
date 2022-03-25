package No1001_1050;

import java.util.*;

public class No1029_TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;

        for(int index = 0; index < n; index++){
            total += costs[index][0] + costs[index + n][1];
        }
        return total;
    }
}
