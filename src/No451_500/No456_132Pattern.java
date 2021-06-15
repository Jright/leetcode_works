package No451_500;

import java.util.Map;
import java.util.TreeMap;

public class No456_132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }

        int leftMin = nums[0];

        TreeMap<Integer, Integer> rightValues = new TreeMap<>();

        for(int i = 2; i < nums.length; i++){
            rightValues.put(nums[i], rightValues.getOrDefault(nums[i], 0) + 1);
        }

        for(int j = 1; j < nums.length - 1; j++){
            if(leftMin < nums[j]){
                Integer next = rightValues.ceilingKey(leftMin + 1);
                if(next !=  null && next < nums[j]){
                    return true;
                }else{
                    continue;
                }
            }

            if(nums[j] < leftMin){
                leftMin = nums[j];
            }

            rightValues.put(nums[j + 1], rightValues.get(nums[j + 1]) - 1);

            if(rightValues.get(nums[j + 1]) == 0){
                rightValues.remove(nums[j + 1]);
            }
        }

        return false;
    }
}
