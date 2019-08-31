package No1_50;

import java.util.*;

public class No31_NextPermutation {

    public static void nextPermutation(int[] nums) {

        if(nums == null || nums.length <= 1){
            return;
        }

        int length = nums.length;
        List<Integer> numList = new ArrayList<>();

        for(int i = length - 1; i >= 1; i--){
            if(nums[i - 1] < nums[i]){

                int temp = nums[length - 1];
                int tempPosition = length - 1;

                for(int j = length - 1; j >= i; j--){

                    if(nums[j] > nums[i - 1]){ // TODO Why this judgement? It
                        //TODO should pick the least value that greater than nums[i - 1]
                        temp = nums[j];
                        tempPosition = j;
                        break;
                    }
                }

                swap(nums, i - 1, tempPosition);
                Arrays.sort(nums, i, length);
                return;
            }
        }

        reverse(nums);
    }

    private static void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    private static void reverse(int[] nums){
        int i, k, t;
        int n = nums.length;
        for (i = 0; i < n / 2; i++) {
            t = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = t;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1};
        nextPermutation(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }

    }
}
