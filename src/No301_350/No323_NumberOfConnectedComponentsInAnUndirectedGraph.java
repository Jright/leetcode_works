package No301_350;

public class No323_NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for(int index = 0; index < edges.length; index++){
            int[] edge = edges[index];
            n -= uf.union(edge[0], edge[1]);
        }
        return n;
    }

    class UnionFind{
        private int[] arr;
        private int[] rank;
        public UnionFind(int size){
            this.arr = new int[size];
            this.rank = new int[size];
            for(int index = 0; index < size; index++){
                arr[index] = index;
                rank[index] = 1;
            }
        }

        public int union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY){
                if(rank[rootX] < rank[rootY]){
                    arr[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                }else{
                    arr[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                }

            }else{
                return 0;
            }

            return 1;
        }

        public int find(int x){

            if(arr[x] == x){
                return x;
            }

            return arr[x] = find(arr[x]);
        }
    }
}
