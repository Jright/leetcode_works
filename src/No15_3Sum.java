import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO
public class No15_3Sum {

    public static void main(String[] args){

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            if(nums[i] > 0){
                return resultList;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                int add = nums[i] + nums[start] + nums[end];

                if(add > 0){
                    end--;
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
                    start++;
                }
            }

        }


        return resultList;
    }
}
