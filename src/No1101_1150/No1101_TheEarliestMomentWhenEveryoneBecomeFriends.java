package No1101_1150;

import java.util.Arrays;

public class No1101_TheEarliestMomentWhenEveryoneBecomeFriends {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, java.util.Comparator.comparingInt(o -> o[0]));

        UnionFind uf = new UnionFind(n);
        int count = n;
        for(int index = 0; index < logs.length; index++){
            int[] log = logs[index];
            int unionRes = uf.union(log[1], log[2]);
            count -= unionRes;
            if(count == 1){
                return log[0];
            }
        }

        return -1;
    }


    class UnionFind{
        private int[] nodes;
        private int[] rank;

        public UnionFind(int size){
            this.nodes = new int[size];
            this.rank = new int[size];
            for(int index = 0; index < size; index++){
                nodes[index] = index;
                rank[index] = 1;
            }
        }

        public int find(int x){
            if(nodes[x] == x){
                return x;
            }
            int rootX = nodes[x];
            return nodes[x] = find(rootX);
        }

        public int union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return 0;
            }

            if(rank[rootX] < rank[rootY]){
                nodes[rootY] = rootX;
            }else if(rank[rootX] > rank[rootY]){
                nodes[rootX] = rootY;
            }else{
                nodes[rootX] = rootY;
                rank[rootY]++;
            }
            return 1;
        }
    }
}
