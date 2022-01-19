package No1001_1050;

public class No1137_NthTribonacciNumber {
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int index = 3; index < dp.length; index++){
            dp[index] = dp[index - 3] + dp[index - 2] + dp[index - 1];
        }

        return dp[n];
    }
}
