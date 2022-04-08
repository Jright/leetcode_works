package No1001_1050;

import java.util.Collections;
import java.util.PriorityQueue;

public class No1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue =
                new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            pQueue.add(stones[i]);
        }

        while (pQueue.size() > 1) {
            int stone1 = pQueue.remove();
            int stone2 = pQueue.remove();
            if (stone1 != stone2) {
                pQueue.add(stone1 - stone2);
            }
        }

        return pQueue.isEmpty() ? 0 : pQueue.remove();
    }
}

