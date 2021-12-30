package No701_750;

import java.util.*;

public class No743_NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int index = 0; index < times.length; index++) {
            int[] time = times[index];
            map.putIfAbsent(time[0], new ArrayList<int[]>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((time1, time2) -> time1[0] - time2[0]);
        pq.offer(new int[]{0, k});

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int dist = info[0];
            int node = info[1];
            if (visited.containsKey(node)) {
                continue;
            }

            visited.put(node, dist);

            if (map.containsKey(node)) {
                for (int[] edge : map.get(node)) {
                    int nb = edge[0];
                    int dist2 = edge[1];
                    if (!visited.containsKey(nb)) {
                        pq.offer(new int[]{dist + dist2, nb});
                    }
                }
            }
        }

        if (visited.size() != n) {
            return -1;
        }

        int ans = 0;

        for (int cand : visited.values()) {
            ans = Math.max(ans, cand);
        }

        return ans;
    }
}
