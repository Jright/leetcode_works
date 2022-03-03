package No401_450;

public class No413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }

        int[] dp = new int[nums.length];

        int sum = 0;

        for(int index = 2; index < nums.length; index++){
            if(nums[index] - nums[index - 1] == nums[index - 1] - nums[index - 2]){
                dp[index] = 1 + dp[index - 1];
                sum += dp[index];
            }
        }
        return sum;
    }
}
