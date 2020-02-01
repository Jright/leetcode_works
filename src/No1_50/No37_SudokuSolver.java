package No1_50;

public class No37_SudokuSolver {

    private int[][] rowMap = new int[10][10];
    private int[][] columnMap = new int[10][10];
    private int[][] blockMap = new int[10][10];
    private int[][] su = new int[10][10];

    public void solveSudoku(char[][] board) {


        for(int i0 = 0;i0 < 9; i0++){
            for(int j0 = 0; j0 < 9; j0++){
                if(board[i0][j0] != '.'){
                    su[i0][j0] = (int)(board[i0][j0] - '0');
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowMap[i][board[i][j] - '0']++;
                    columnMap[j][board[i][j] - '0']++;
                    int no = (i / 3) * 3 + j / 3;
                    blockMap[no][board[i][j] - '0']++;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int n) {
        if (n == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = (char) (su[i][j] + '0');
                }
            }
            return;
        }

        int x = n / 9;
        int y = n % 9;

        if (su[x][y] != 0) {
            dfs(board, n + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                int no = (x / 3) * 3 + y / 3;
                if (rowMap[x][i] != 0 || columnMap[y][i] != 0 || blockMap[no][i] != 0) {
                    continue;
                }

                su[x][y] = i;

                rowMap[x][i]++;
                columnMap[y][i]++;
                blockMap[no][i]++;

                dfs(board, n + 1);

                rowMap[x][i]--;
                columnMap[y][i]--;
                blockMap[no][i]--;
                su[x][y] = 0;
            }
        }
    }
}
