import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TODO Wrong Answer
public class No18_4Sum {

    public static void main(String[] args){
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> resultFourList = new ArrayList<>();

        if(nums == null || nums.length < 4){
            return resultFourList;
        }

        //Turn fourSum into threeSum
        for(int i = 0; i < nums.length - 3; i++){
            //In this first loop, we try to find number array from i + 1 to num.length - 1 to find three numbers whose sum is target - nums[i]
            int threeSumTarget = target - nums[i];
            List<List<Integer>> resultThreeLists = threeSum(nums, i + 1, threeSumTarget);
            for(List<Integer> list : resultThreeLists){
                list.add(nums[i]);
                resultFourList.add(list);
            }
        }

        return resultFourList;
    }


    public static List<List<Integer>> threeSum(int[] nums, int start, int target){
        List<List<Integer>> resultThreeList = new ArrayList<>();

        for(int j = 0; j < nums.length - 2; j++){
            int twoSumTarget = target - nums[j];
            List<List<Integer>> resultTwoLists = twoSum(nums, j + 1, twoSumTarget);
            for(List<Integer> list : resultTwoLists){
                list.add(nums[j]);
                resultThreeList.add(list);
            }
        }

        return resultThreeList;

    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> resultTwoList = new ArrayList<>();

        int end = nums.length - 1;
        while(start < end){
            int twoSum = nums[start] + nums[end];
            if(twoSum > target){
                start++;
            }else if(twoSum < target){
                end--;
            }else{
                List<Integer> resultList = new ArrayList<>();
                resultList.add(nums[start]);
                resultList.add(nums[end]);

                if(!resultTwoList.contains(resultList)){
                    resultTwoList.add(resultList);
                }

                int preStart = start;

                while(start < end && nums[start] == nums[preStart]){
                    start++;
                }
                end--;
            }
        }

        return resultTwoList;

    }

}
