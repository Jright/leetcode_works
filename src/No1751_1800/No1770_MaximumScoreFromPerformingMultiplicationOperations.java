package No1751_1800;

import java.util.HashMap;
import java.util.Map;

public class No1770_MaximumScoreFromPerformingMultiplicationOperations {

    int n;
    int m;
    Integer[][] dp;
    int[] nums;
    int[] multipliers;

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        if(m == 1){
            return Math.max(multipliers[0] * nums[0], multipliers[0] * nums[n - 1]);
        }
        dp = new Integer[m][m];
        return dp(0, 0);
    }

    private int dp(int left, int index){
        if(index == m){
            return 0;
        }
        if(dp[left][index] != null){
            return dp[left][index];
        }
        int right = n - left;
        int pickLeft = dp(left + 1, index + 1) + this.nums[left] * this.multipliers[index];
        int pickRight = dp(left, index + 1) + this.nums[n - (index - left) - 1] * this.multipliers[index];
        dp[left][index] = Math.max(pickLeft, pickRight);
        return dp[left][index];
    }
}
