package No1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18_4Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();

        int length = nums.length;
        if (length < 4) {
            return resultList;
        }

        for (int i = 0; i < length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

//            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
//                break;
//            }
//
//            if(nums[length - 1] + nums[length - 2] + nums[length - 3] + nums
//            [length - 4] < target){
//                break;
//            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

//                if(nums[j - 1] + nums[j] + nums[j + 1] + nums[j + 2] > target){
//                    break;
//                }
//
//                if(nums[length - 1] + nums[length - 2] + nums[length - 3] + nums
//                        [length - 4] < target){
//                    break;
//                }

                int secondTarget = target - nums[i] - nums[j];

                int k = j + 1;
                int l = length - 1;

                while (k < l) {
                    if (nums[k] + nums[l] > secondTarget) {
                        l--;
                    } else if (nums[k] + nums[l] < secondTarget) {
                        k++;
                    } else {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[l]);
                        resultList.add(result);


                        k++;
                        l--;

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }

        return resultList;

    }
}
