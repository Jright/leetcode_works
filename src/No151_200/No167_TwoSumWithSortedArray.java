package No151_200;

public class No167_TwoSumWithSortedArray {

    public int[] twoSum(int[] numbers, int target) {

        if(numbers.length < 2){
            return null;
        }

        if(target < numbers[0]){
            return null;
        }

        int l = 0, r = numbers.length - 1;

        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l + 1, r + 1};
            }else if(numbers[l] + numbers[r] > target){
                r--;
            }else{
                l++;
            }
        }

        return null;
    }
}
