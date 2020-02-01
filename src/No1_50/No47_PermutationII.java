package No1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47_PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(result, temp, nums, used);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                helper(result, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
