package No1551_1600;

import java.util.*;

public class No1584_MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        if(points.length < 2){
            return 0;
        }

        Set<Integer> minimumSpanningTree = new HashSet<>();
        minimumSpanningTree.add(0);
        int[] cuts = new int[points.length];

        for(int index = 1; index < cuts.length; index++){
            cuts[index] = Math.abs(points[index][0] - points[0][0]) + Math.abs(points[index][1] - points[0][1]);
        }

        int ans = 0;

        while(minimumSpanningTree.size() != points.length){
            int next = -1;
            for(int index = 0; index < cuts.length; index++){
                if(minimumSpanningTree.contains(index)){
                    continue;
                }

                if(next == -1 || cuts[next] > cuts[index]){
                    next = index;
                }
            }
            ans += cuts[next];
            minimumSpanningTree.add(next);

            for(int index = 0; index < cuts.length; index++){
                if(!minimumSpanningTree.contains(index)){
                    cuts[index] = Math.min(cuts[index],
                            Math.abs(points[index][0] - points[next][0]) + Math.abs(points[index][1] - points[next][1]));
                }
            }
        }

        return ans;
    }
//    =================Krusgal's algorithm=========================================
//    public int minCostConnectPoints(int[][] points) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                int[] p = points[i];
//                int[] q = points[j];
//                int dist = Math.abs(p[0] - q[0]) + Math.abs(p[1] - q[1]);
//                pq.add(new int[]{dist, i, j});
//            }
//        }
//
//        Set<Integer> connectedSet = new HashSet<>();
//
//
//        int count = 0;
//        int cost = 0;
//
//        UnionFind uf = new UnionFind(points.length);
//        while(count < points.length - 1){
//            int[] edge = pq.poll();
//            if(uf.find(edge[1]) != uf.find(edge[2])){
//                cost += edge[0];
//                count++;
//                uf.union(edge[1], edge[2]);
//            }
//        }
//        return cost;
//    }
//
//    class UnionFind {
//        private int size;
//        private int[] arr;
//        private int[] rank;
//
//        public UnionFind(int size) {
//            this.arr = new int[size];
//            this.rank = new int[size];
//
//            for (int index = 0; index < size; index++) {
//                arr[index] = index;
//                rank[index] = 1;
//            }
//        }
//
//        public void union(int a, int b) {
//            int rootA = find(a);
//            int rootB = find(b);
//            if (rootA == rootB) {
//                return;
//            }
//            if(rank[a] > rank[b]){
//                arr[rootB] = rootA;
//            }else if(rank[a] < rank[b]){
//                arr[rootA] = rootB;
//            }else{
//                arr[rootA] = rootB;
//                rank[rootB]++;
//            }
//            return;
//        }
//
//        public int find(int x) {
//            if(arr[x] == x){
//                return x;
//            }else{
//                return arr[x] = find(arr[x]);
//            }
//        }
//    }
//  =================Krusgal's algorithm=========================================
}
