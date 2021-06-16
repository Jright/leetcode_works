package No451_500;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

public class No456_132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }

        int rightMax = Integer.MIN_VALUE;
        int n = nums.length;
        ArrayDeque<Integer> twoCandidateStack = new ArrayDeque<>();
        twoCandidateStack.push(nums[n - 1]);

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < rightMax){
                return true;
            }

            while (!twoCandidateStack.isEmpty() && twoCandidateStack.peek() < nums[i]){
                rightMax = twoCandidateStack.pop();
            }

            if(nums[i] > rightMax){
                twoCandidateStack.push(nums[i]);
            }
        }

        return false;
    }
}
