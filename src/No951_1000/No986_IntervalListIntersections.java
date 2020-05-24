package No951_1000;

import java.util.ArrayList;
import java.util.List;

public class No986_IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> result = new ArrayList<>();
        if(A == null || A.length == 0 || B == null || B.length== 0){
            return result.toArray(new int[result.size()][]);
        }

        int m = A.length;
        int n = B.length;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);

            if(endMin >= startMax){
                result.add(new int[]{startMax, endMin});
            }

            if(A[i][1] == endMin){
                i++;
            }

            if(B[j][1] == endMin){
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);

    }

}
