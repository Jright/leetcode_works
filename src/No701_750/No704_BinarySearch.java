package No701_750;

public class No704_BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if(nums[0] > target || nums[n - 1] < target){
            return -1;
        }

        int left = 0;
        int right = n - 1;
        int mid;

        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
