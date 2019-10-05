package No1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40_CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backTrack(result, temp, candidates, target, 0);

        return result;

    }

    private static void backTrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target,
                           int position){

        if(target == 0){
            result.add(new ArrayList(temp));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = position; i < candidates.length; i++){
            if(i > position && candidates[i] == candidates[i - 1]){
                continue;
            }

            temp.add(temp.size(), candidates[i]);

            backTrack(result, temp, candidates, target - candidates[i], i + 1);

            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;


        List<List<Integer>> lists = combinationSum2(nums, target);
        for(List<Integer> num : lists){
            for(int n : num){
                System.out.println(n);
            }
        }
    }

}
