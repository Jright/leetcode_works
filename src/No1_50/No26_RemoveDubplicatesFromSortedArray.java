package No1_50;

public class No26_RemoveDubplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int pointer = 0;
        int checkRunner = 1;

        for(; checkRunner < nums.length; checkRunner++){
            if(nums[pointer] != nums[checkRunner]){
                pointer++;
                nums[pointer] = nums[checkRunner];
            }
        }

        return pointer + 1;
    }

}
