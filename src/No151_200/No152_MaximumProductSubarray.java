package No151_200;

public class No152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int max = nums[0];
        int min = max;
        int result = max;

        for(int index = 1; index < nums.length; index++){

            if(nums[index] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[index], max * nums[index]);
            min = Math.min(nums[index], min * nums[index]);

            result = Math.max(result, max);

        }

        return result;
    }
}
