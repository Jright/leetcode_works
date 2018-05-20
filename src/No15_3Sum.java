import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO Still Exceeds Time Limit
public class No15_3Sum {

    public static void main(String[] args){

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){

            if(nums[i] > 0){
                return resultList;
            }

            int start = i + 1;
            int end = nums.length - 1;

            if(nums[end] < 0){
                return resultList;
            }


            while(start < end){
                int add = nums[i] + nums[start] + nums[end];

                if(add > 0){
                    end--;
                    if(nums[end] < 0){
                        return resultList;
                    }
                }else if(add < 0){
                    start++;
                }else{
                    ArrayList<Integer> sumList = new ArrayList<>();
                    sumList.add(nums[i]);
                    sumList.add(nums[start]);
                    sumList.add(nums[end]);
                    if(!resultList.contains(sumList)){
                        resultList.add(sumList);
                    }

                    int preStart = start;

                    while (start < end && nums[start] == nums[preStart]){// Here
                        start++;
                    }
                    end--;
                }
            }

            int prevI = i;
            while (i < nums.length && nums[i] == nums[prevI]){
                i++;
            } // And Here
//            i--;
        }


        return resultList;
    }
}
