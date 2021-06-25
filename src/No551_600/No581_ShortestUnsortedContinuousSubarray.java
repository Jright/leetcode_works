package No551_600;

import java.util.ArrayDeque;
import java.util.Deque;

public class No581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = Integer.MAX_VALUE;
        int right = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int tempMax = nums[0];
        for(int index = 0; index < nums.length; index++){
            if(stack.isEmpty()){
                stack.push(nums[index]);
                continue;
            }

            if(!stack.isEmpty() && nums[index] >= stack.peek()){
                stack.push(nums[index]);
                continue;
            }

            while(!stack.isEmpty() && nums[index] < stack.peek()){
                right = index;
                tempMax = Math.max(stack.pop(), tempMax);
            }

            left = Math.min(stack.size(), left);
            stack.push(tempMax);
        }
        return (left != Integer.MAX_VALUE) ? (right - left + 1) : 0;
    }
}
