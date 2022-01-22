package No251_300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return 1;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 1;

        for(int index = 1; index < nums.length; index++){
            for(int j = 0; j < index; j++){
                if(nums[index] > nums[j]){
                    dp[index] = Math.max(dp[index], dp[j] + 1);
                }
            }
        }

        for(int num : dp){
            result = Math.max(num, result);
        }

        return result;
    }
}
