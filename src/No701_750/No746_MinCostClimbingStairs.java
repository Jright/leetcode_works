package No701_750;

public class No746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length <= 1){
            return cost.length == 0 ? 0 : cost[0];
        }

        int[] dp = new int[cost.length + 1];

        for(int index = 2; index < dp.length; index++){
            dp[index] = Math.min(dp[index - 2] + cost[index - 2], dp[index - 1] + cost[index - 1]);
        }

        return dp[dp.length - 1];
    }
}
