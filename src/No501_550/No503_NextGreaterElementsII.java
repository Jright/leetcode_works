package No501_550;

import java.util.ArrayDeque;

public class No503_NextGreaterElementsII {

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];


        for(int i = nums.length - 1; i >= 0; i--){
            stack.push(i);
        }

        for(int i = nums.length - 1; i >= 0; i--){

            res[i] = -1;

            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                res[i] = nums[stack.peek()];
            }

            stack.push(i);

        }

        return res;
    }

}
