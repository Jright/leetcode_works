package No151_200;

public class No198_HouseRobber {

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int[] maxRecord = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if((i - 2) >= 0){
                int currentMax = Math.max(maxRecord[i - 2] + nums[i], maxRecord[i - 1]);
                maxRecord[i] = currentMax;
            }else{
                int currentMax = 0;
                if(i == 0){
                    currentMax = nums[0];
                }else{
                    currentMax = Math.max(nums[i], nums[i -1]);
                }
                maxRecord[i] = currentMax;
            }
        }

        return maxRecord[nums.length - 1];
    }

}
