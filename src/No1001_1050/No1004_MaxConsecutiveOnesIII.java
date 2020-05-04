package No1001_1050;

public class No1004_MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        if(A.length == 0){
            return 0;
        }

        int left = 0;
        int right = 0;

        int max = 0;
        int zeros = 0;

        while(right < A.length){
            if(A[right] == 1){
                max = Math.max(max, right - left + 1);
                right++;
            }else{
                if(zeros < K){
                    max = Math.max(max, right - left + 1);
                    zeros++;
                    right++;
                }else{
                    if(A[left] == 0){
                        zeros--;
                    }
                    left++;
                }
            }
        }
        return max;
    }
}
