package No451_500;

import java.util.HashMap;
import java.util.Map;

public class No454_4SumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        return kSumCount(new int[][]{nums1, nums2, nums3, nums4});
    }

    private int kSumCount(int[][] lists){
        Map<Integer, Integer> map = new HashMap<>();
        hashing(lists, map, 0, 0);
        return countComplement(lists, map, lists.length / 2, 0);
    }

    private void hashing(int[][] lists, Map<Integer, Integer> map, int index, int sum){
        if(index == lists.length / 2){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }else{
            for(int a : lists[index]){
                hashing(lists, map, index + 1, sum + a);
            }
        }
    }

    private int countComplement(int[][] lists, Map<Integer, Integer> map, int index, int complement){
        if(index == lists.length){
            return map.getOrDefault(complement, 0);
        }

        int count = 0;
        for(int a : lists[index]){
            count += countComplement(lists, map, index + 1, complement - a);
        }
        return count;
    }
}
