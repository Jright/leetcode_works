package No151_200;

import java.util.*;

public class No169_MajorityElement {

    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        int max = Integer.MIN_VALUE;
        int key = -1;
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() > max){
                max = next.getValue();
                key = next.getKey();
            }
        }

        return key;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int i = majorityElement(nums);
        System.out.println(i);
    }

}
