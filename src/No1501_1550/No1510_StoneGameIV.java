package No1501_1550;

public class No1510_StoneGameIV {
    public boolean winnerSquareGame(int n) {
        if(n == 1){
            return true;
        }

        if(n == 2){
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        for(int index = 0; index < n + 1; index++){
            for(int k = 1; k * k <= index; k++){
                if(dp[index - k * k] == false){
                    dp[index] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
