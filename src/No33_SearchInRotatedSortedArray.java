public class No33_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        // First, find the pivot point...
        while (right - left > 1) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (target < nums[0]) {
            left = right;
            right = nums.length;
        } else {
            left = 0;
        }

        // When the nums.length is too small (1, 2)...
        if (left >= nums.length) {
            return -1;
        }

        while (right - left > 1) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) { // The target may not exist in the whole array...
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {

    }

}
