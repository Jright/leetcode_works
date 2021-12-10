package No1301_1350;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No1338_ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        if(arr.length <= 2){
            return 1;
        }

        int[] occur = new int[100001];

        for(int index = 0; index < arr.length; index++){
            occur[arr[index]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int index = 0; index < occur.length; index++){
            if(occur[index] != 0){
                pq.add(occur[index]);
            }
        }

        int res = 0;
        int count = 0;

        while(count < (arr.length) / 2){
            count += pq.poll();
            res++;
        }

        return res;
    }
}
