package No101_150;

public class No136_SingleNumber {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
