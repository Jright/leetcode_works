//Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
//
//        Write an algorithm to minimize the largest sum among these m subarrays.
//
//        Note:
//        If n is the length of array, assume the following constraints are satisfied:
//
//        1 ≤ n ≤ 1000
//        1 ≤ m ≤ min(50, n)
//        Examples:
//
//        Input:
//        nums = [7,2,5,10,8]
//        m = 2
//
//        Output:
//        18
//
//        Explanation:
//        There are four ways to split nums into two subarrays.
//        The best way is to split it into [7,2,5] and [10,8],
//        where the largest sum among the two subarrays is only 18.

public class No410_SplitArrayLargestNum {

    public boolean guess(long mid, int[] nums, int m){

        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i]> mid){
                --m;
                sum = nums[i];
                if(nums[i] > mid){
                    return false;
                }
            }else{
                sum = sum + nums[i];
            }
        }

        return m > 0;//After the for loop, there is still value inside the sum. At least it should be contained in one box.
    }

    public int splitArray(int[] nums, int m) {
        long R = 1; // TODO Why 1, not 0 ???
        for(int num : nums){
            R += num;
        }
        long L = 0;
        long ans = 0;
        long mid;


        while(L < R){
            mid = (L + R) / 2;
            if(guess(mid, nums, m)){
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return (int)ans;

    }

}
