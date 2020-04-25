package No51_100;

public class No64_MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] min = new int[m][n];

        min[0][0] = grid[0][0];

        for(int i = 1; i < m; i++){
            min[i][0] = min[i - 1][0] + grid[i][0];
        }

        for(int j = 1; j < n; j++){
            min[0][j] = min[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
            }
        }



        return min[m - 1][n - 1];
    }


}