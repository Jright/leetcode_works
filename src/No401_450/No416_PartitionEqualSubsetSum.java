package No401_450;

import java.util.Arrays;

public class No416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }


        if (totalSum % 2 != 0) {
            return false;
        }

        int subSetSum = totalSum / 2;

        int n = nums.length;

        Boolean[][] dp = new Boolean[n + 1][subSetSum + 1];

        return helper(nums, n - 1, subSetSum, dp);
    }

    private boolean helper(int[] nums, int n, int subSetSum, Boolean[][] dp){
        if(subSetSum == 0){
            return true;
        }

        if(n == 0 || subSetSum < 0){
            return false;
        }

        if(dp[n][subSetSum] != null){
            return dp[n][subSetSum];
        }

        boolean result = helper(nums, n - 1, subSetSum - nums[n - 1], dp) ||
                helper(nums, n - 1, subSetSum, dp);

        dp[n][subSetSum] = result;

        return result;
    }
}
