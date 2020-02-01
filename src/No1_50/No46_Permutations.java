package No1_50;

import java.util.ArrayList;
import java.util.List;

// Copied answer:
// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
public class No46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            result.add(list);
        }else{
            for(int i = 0; i < nums.length; i++){
                if(list.contains(nums[i])){
                    continue;
                }else {
                    list.add(nums[i]);
                    helper(result, list, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
