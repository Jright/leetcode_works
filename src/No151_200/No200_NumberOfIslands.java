package No151_200;

public class No200_NumberOfIslands {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        visited = new boolean[m][n];

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]){
                    continue;
                }

                if(grid[i][j] == '0'){
                    continue;
                }

                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, m, n, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int m, int n, char[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]){
            return;
        }

        visited[i][j] = true;

        if(grid[i][j] == '1'){
            dfs(i + 1, j, m, n, grid);
            dfs(i, j + 1, m, n, grid);
            dfs(i - 1, j, m, n, grid);
            dfs(i, j - 1, m, n, grid);
        }
    }
}
