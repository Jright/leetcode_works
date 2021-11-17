package No1151_1200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No1168_OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> orderedEdges = new ArrayList<>(n + 1 + pipes.length);

        for (int i = 0; i < wells.length; i++) {
            orderedEdges.add(new int[]{0, i + 1, wells[i]});
        }

        for (int i = 0; i < pipes.length; i++) {
            int[] edge = pipes[i];
            orderedEdges.add(edge);
        }

        Collections.sort(orderedEdges, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int totalCost = 0;

        for (int[] edge : orderedEdges) {
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];
            if (uf.union(house1, house2)) {
                totalCost += cost;
            }
        }

        return totalCost;
    }

    class UnionFind {
        private int[] group;
        private int[] rank;

        public UnionFind(int size) {
            group = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i < size + 1; ++i) {
                group[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int person) {
            if (group[person] != person) {
                group[person] = find(group[person]);
            }
            return group[person];
        }

        public boolean union(int person1, int person2) {
            int group1 = find(person1);
            int group2 = find(person2);

            if (group1 == group2) {
                return false;
            }

            if (rank[group1] > rank[group2]) {
                group[group2] = group1;
            } else if (rank[group1] < rank[group2]) {
                group[group1] = group2;
            } else {
                group[group1] = group2;
                rank[group2] += 1;
            }

            return true;
        }
    }

}
