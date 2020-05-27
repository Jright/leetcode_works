package No1001_1050;

public class No1035_UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][B.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(A, B, 0, 0, dp);
    }

    private int helper(int[] A, int[] B, int i , int j, int[][] dp) {

        if(i == A.length || j == B.length){
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (A[i] == B[j]) {
            dp[i][j] = 1 + helper(A, B, i + 1, j + 1, dp);
        }else{
            dp[i][j] = Math.max(helper(A, B, i + 1, j, dp), helper(A, B, i, j + 1, dp));
        }
        return dp[i][j];
    }

}
