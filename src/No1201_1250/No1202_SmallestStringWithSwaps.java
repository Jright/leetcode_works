package No1201_1250;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class No1202_SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, PriorityQueue<Character>> groupIndexMap = new HashMap<>();
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair: pairs){
            uf.union(pair.get(0), pair.get(1));
        }

        for(int index = 0; index < s.length(); index++){
            int root = uf.find(index);
            groupIndexMap.putIfAbsent(root, new PriorityQueue<>());
            groupIndexMap.get(root).offer(s.charAt(index));
        }

        StringBuilder sb = new StringBuilder();

        for(int index = 0; index < s.length(); index++){
            int indexRoot = uf.find(index);
            PriorityQueue<Character> pq = groupIndexMap.get(indexRoot);
            sb.append(pq.poll());
        }

        return sb.toString();
    }


    class UnionFind{
        private int size;
        private int[] arr;
        private int[] rank;

        public UnionFind(int size){
            arr = new int[size];
            rank = new int[size];
            for(int index = 0; index < size; index++){
                arr[index] = index;
                rank[index] = 1;
            }
        }

        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py){
                return;
            }
            else if(rank[px] > rank[py]){ //low rank tree merge into high rank tree
                arr[py] = px;
            }
            else if(rank[py] > rank[px]){
                arr[px] = py;
            }
            else {
                arr[px] = py;
                rank[py]++;
            }
            return;
        }

        public int find(int x){
            if(arr[x] == x){
                return x;
            }else{
                return arr[x] = find(arr[x]);
            }
        }
    }
}
