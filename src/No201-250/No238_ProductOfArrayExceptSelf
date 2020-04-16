package No201_250;

public class No238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] result = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int j = 0; j < nums.length; j++) {
            result[j] = L[j] * R[j];
        }
        return result;
    }
}