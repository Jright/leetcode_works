package No401_450;

public class No421_MaximumXOROfTwoNumbersInAnArray {
    // TODO Time Limit Exceeded
    public int findMaximumXOR(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}
