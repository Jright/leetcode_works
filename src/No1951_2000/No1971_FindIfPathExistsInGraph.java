package No1951_2000;

import java.util.*;

public class No1971_FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {

        if(start == end){
            return true;
        }

        UnionFind set = new UnionFind(n);
        for(int[] edge : edges){
            set.union(edge[0], edge[1]);
        }

        return set.areConnected(start, end);

    }

    class UnionFind{
        private int[] parent;
        private int[] rank;

        public UnionFind(int size){
            this.parent = new int[size];
            this.rank = new int[size];
            for(int index = 0; index < this.parent.length; index++){
                this.parent[index] = index;
                this.rank[index] = 1;
            }
        }

        public boolean areConnected(int u, int v){
            return find(u) == find(v);
        }

        public void union(int u, int v){
            if(u != v){
                int a = find(u);
                int b = find(v);
                if(a != b){
                    if(rank[a] > rank[b]){
                        parent[b] = a;
                        rank[a] += rank[b];
                    }else{
                        parent[a] = b;
                        rank[b] += rank[a];
                    }
                }
            }
        }

        private int find(int u){
            int x = u;
            while(x != this.parent[x]){
                x = this.parent[x];
            }

            this.parent[u] = x;
            return x;
        }
    }
}
