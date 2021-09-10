package No1801_1850;

public class No1822_SignOfTheProductOfAnArray {

    public int arraySign(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int negativeCount = 0;

        for(int num: nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                negativeCount++;
            }
        }

        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
