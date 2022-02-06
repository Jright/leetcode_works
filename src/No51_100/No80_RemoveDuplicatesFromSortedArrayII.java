package No51_100;

public class No80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {

        if(nums.length <= 2){
            return nums.length;
        }

        int k = 0;
        int[] arr = new int[20001];
        int boundary = 10000;

        for(int index = 0; index < nums.length; index++){
            int newIndex = nums[index] < 0 ? -(nums[index]) + boundary : nums[index];
            arr[newIndex]++;

            if(arr[newIndex] > 2){
                continue;
            }

            nums[k] = nums[index];
            k++;
        }

        return k;
    }
}
