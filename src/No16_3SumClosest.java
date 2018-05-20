import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No16_3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        ArrayList<Integer> resultList = new ArrayList<>();
        int smallestGap = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++){

            int start = i + 1;
            int end = nums.length - 1;


            while(start < end){
                int difference = nums[i] + nums[start] + nums[end] - target;
                if(difference > 0){
                    if(difference < Math.abs(smallestGap)){
                        smallestGap = difference;
                    }
                    end--;
                }else if(difference < 0){
                    if( Math.abs(difference) < Math.abs(smallestGap)){
                        smallestGap = difference;
                    }
                    start++;
                }else{
                    return nums[i] + nums[start] + nums[end];
                }
            }
        }

        return smallestGap + target;

    }

}
