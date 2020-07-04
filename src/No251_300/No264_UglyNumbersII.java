package No251_300;

public class No264_UglyNumbersII {

    public int nthUglyNumber(int n) {
        int[] dp = new int[1690];

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        dp[0] = 1;

        int ugly = dp[0];

        for(int i = 1; i < 1690; i++){
            ugly = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));

            if(ugly == dp[i2] * 2){i2++;}
            if(ugly == dp[i3] * 3){i3++;}
            if(ugly == dp[i5] * 5){i5++;}
            dp[i] = ugly;
        }

        return dp[n - 1];
    }

}
