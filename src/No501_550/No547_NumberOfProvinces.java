package No501_550;

public class No547_NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int cityAmount = isConnected.length;

        if(cityAmount <= 1){
            return cityAmount;
        }

        UnionFind uf = new UnionFind(cityAmount);

        for(int index = 0; index < cityAmount - 1; index++){
            for(int index2 = index + 1; index2 < cityAmount; index2++){
                if(isConnected[index][index2] == 1){
                    uf.union(index, index2);
                }
            }
        }

        return uf.count();
    }

    class UnionFind{
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }
}
