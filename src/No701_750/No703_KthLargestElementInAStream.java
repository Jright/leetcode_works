package No701_750;

import java.util.PriorityQueue;

public class No703_KthLargestElementInAStream {
    private int k;
    private PriorityQueue<Integer> pq;

    public No703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for(int num : nums){
            pq.offer(num);
        }

        while(pq.size() > k){
            pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k){
            pq.poll();
        }

        return pq.peek();
    }
}
