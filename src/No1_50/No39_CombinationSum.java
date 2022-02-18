package No1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        backtrack(resList, currList, candidates, 0, target);
        return resList;
    }

    private void backtrack(List<List<Integer>> resList, List<Integer> currList, int[] candidates, int index, int target){
        if(index == candidates.length){
            if(target == 0){
                resList.add(new ArrayList<>(currList));
            }
            return;
        }

        if(target < 0){
            return;
        }

        if(candidates[index] <= target){
            currList.add(currList.size(), candidates[index]);
            backtrack(resList, currList, candidates, index, target - candidates[index]);
            currList.remove(currList.size() - 1);
        }

        backtrack(resList, currList, candidates, index + 1, target);
    }
}
