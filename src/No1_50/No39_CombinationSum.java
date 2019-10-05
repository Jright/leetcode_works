package No1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(result, temp, candidates, 0, target);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, int[] candidates,int position, int target){

        if(target == 0){
            result.add(temp);
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = position; i < candidates.length && target >= candidates[i]; i++){

            temp.add(temp.size(), candidates[i]);
            backTrack(result, temp, candidates, i, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }

    }

}
