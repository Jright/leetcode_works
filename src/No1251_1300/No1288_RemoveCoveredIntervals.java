package No1251_1300;

import java.util.Arrays;
import java.util.Comparator;

public class No1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int count = 0;
        int end, prevEnd = 0;

        for(int[] curr : intervals){
            end = curr[1];

            if(prevEnd < end){
                count++;
                prevEnd = end;
            }
        }
        return count;
    }
}
