package No1_50;

import java.util.HashSet;

// Inspired by: https://blog.csdn.net/mine_song/article/details/70207326
public class No36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {

            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> columnSet = new HashSet<>();
            HashSet<Character> cubeSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    if (columnSet.contains(board[j][i])) {
                        return false;
                    } else {
                        columnSet.add(board[j][i]);
                    }
                }


                // How to access the i-th cube's j-th element:
                // Find the pattern of the indexes inside each cube.
                // https://blog.csdn.net/mine_song/article/details/70207326
                int rowCubeIndex = 3 * (i / 3) + j / 3;

                int colCubeIndex = 3 * (i % 3) + j % 3;
                if (board[rowCubeIndex][colCubeIndex] != '.') {
                    if (cubeSet.contains(board[rowCubeIndex][colCubeIndex])) {
                        return false;
                    } else {
                        cubeSet.add(board[rowCubeIndex][colCubeIndex]);
                    }
                }
            }
        }
        return true;
    }
}
