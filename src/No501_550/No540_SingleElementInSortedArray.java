package No501_550;

public class No540_SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;
            boolean halvesEven = (right - mid) % 2 == 0;

            if (nums[mid + 1] == nums[mid]) {
                if (halvesEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }

        }
        return nums[left];
    }

}
