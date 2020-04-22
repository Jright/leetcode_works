package No551_600;

import java.util.HashMap;

public class No560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        // boundary check
        if(nums == null || nums.length == 0){
            return 0;
        }
        // store the cumulative sum values for each indicies
        HashMap<Integer, Integer> map = new HashMap<>();
        // empty array is also a sub-array...
        map.put(0, 1);

        int count = 0;

        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            // if cumulative sum sum[j] - sum[i] = k
            // then the sub-array between i and j is sum-k.
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            // record the occurance times of the sum
            map.put(sum, map.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
}
