package No51_100;

import java.util.Arrays;

public class No63_UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];

        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                while(i < m){
                    paths[i][0] = 0;
                    i++;
                }
            }else{
                paths[i][0] = 1;
            }
        }


        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1){
                while(j < n){
                    paths[0][j] = 0;
                    j++;
                }
            }else{
                paths[0][j] = 1;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    paths[i][j] = 0;
                }else{
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
