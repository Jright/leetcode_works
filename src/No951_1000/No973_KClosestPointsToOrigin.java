package No951_1000;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        if(k == points.length){
            return points;
        }

        PriorityQueue<PointDistance> pq = new PriorityQueue<>(new Comparator<PointDistance>() {
            @Override
            public int compare(PointDistance o1, PointDistance o2) {
                if(o1.dist == o2.dist){
                    return 0;
                }else if(o1.dist > o2.dist){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for(int index = 0; index < points.length; index++){
            int[] point = points[index];
            double dist = Math.sqrt(Math.pow(points[index][0], 2) + Math.pow(points[index][1], 2));
            PointDistance pd = new PointDistance();
            pd.index = index;
            pd.dist = dist;
            pq.add(pd);
        }

        int[][] res = new int[k][];
        for(int index = 0; index < k; index++){
            PointDistance pd = pq.poll();
            res[index] = points[pd.index];
        }
        return res;
    }

    private class PointDistance{
        int index;
        double dist;
    }
}
