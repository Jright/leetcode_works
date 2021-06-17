package No401_450;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class No496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <= nums2.length - 1 ; i++){
            int cur = nums2[i];
            if(stack.isEmpty()){
                stack.push(cur);
                continue;
            }

            while(!stack.isEmpty() && cur > stack.peek()){
                int smaller = stack.pop();
                map.put(smaller, cur);
            }

            stack.push(cur);
        }

        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }else{
                res[i] = -1;
            }
        }
        return res;
    }
}
