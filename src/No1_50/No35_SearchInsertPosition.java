package No1_50;

public class No35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }

        if(target < nums[0]){
            return 0;
        }

        int length = nums.length;

        if(target > nums[length - 1]){
            return length;
        }

        int left = 0;
        int right = length - 1;
        int mid = 0;

        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }

        return left;
    }
}
