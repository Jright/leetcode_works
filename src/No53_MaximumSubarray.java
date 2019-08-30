public class No53_MaximumSubarray {

    public int maxSubArray(int[] nums){
        int current = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(current < 0){
                current = nums[i];
            }else{
                current = current + nums[i];
            }
            result = Math.max(current, result);
        }
        return result;
    }
}
