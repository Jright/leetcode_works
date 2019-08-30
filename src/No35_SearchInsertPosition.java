public class No35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int result = 0;
        if(target < nums[0]){
            return result;
        }

        if(target > nums[nums.length - 1]){
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;

        while(right - left > 1){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }

        if(nums[left] == target){
            return left;
        }else if(nums[right] == target){
            return right;
        }else if(nums[left] > target){
            return left;
        }else if(nums[right] < target){
            return right;
        }else{
            return right;
        }
    }
}
