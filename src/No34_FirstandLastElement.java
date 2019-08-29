public class No34_FirstandLastElement {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums.length == 0) {

            return result;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return result;
        }

        result[0] = left;

//        left = 0;
        right = nums.length - 1;
        while (left < right) {
            mid = ((left + right) >> 1) + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        result[1] = right;

        return result;

    }
}
