package No1501_1550;

public class No1512_NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int[] occurArr = new int[101];

        int res = 0;
        for(int index = 0; index < nums.length; index++){
            res += occurArr[nums[index]]++;
        }

        return res;
    }
}
