package No251_300;

public class No283_MoveZeros {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }

        int zeroCount = 0;

        for(int num : nums){
            if(num == 0){
                zeroCount++;
            }
        }

        int fast = 0;
        int slow = 0;

        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while(zeroCount > 0 && slow < nums.length){
            nums[slow] = 0;
            slow++;
            zeroCount--;
        }

    }
}
