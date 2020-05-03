package No501_550;

import java.util.HashMap;
import java.util.Map;

public class No525_ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;

        for(int i = 0; i < nums.length; i++){
            int addValue = nums[i] == 1 ? 1 : -1;
            count += addValue;
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }

        return maxLen;
    }
}
