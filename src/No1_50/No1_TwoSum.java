package No1_50;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jright on 2017/7/30.
 */

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
public class No1_TwoSum {
    public static void main(String[] args){
        int[] array = new int[]{2,7,11,15};
        int target = 26;
        int[] result = getResultIndices(array,target);
        for(int i : result){
            System.out.print(i + " ");
        }
    }

    private static int[] getResultIndices(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0;i < nums.length;i++){
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }



}
