package No951_1000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class No994_RottenOranges {

    class Pair {
        private int row;
        private int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<Pair> rottenQueue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new Pair(i, j));
                }
            }
        }

        int minuteElapsed = -1;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        rottenQueue.offer(new Pair(-1, -1));
        while (!rottenQueue.isEmpty()) {
            Pair p = rottenQueue.poll();
            int row = p.getRow();
            int col = p.getCol();
            if (row == -1) {
                minuteElapsed++;
                if (!rottenQueue.isEmpty()) {
                    rottenQueue.offer(new Pair(-1, -1));
                }
            } else {
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < grid.length &&
                            neighborCol >= 0 && neighborCol < grid[0].length) {
                        if(grid[neighborRow][neighborCol] == 1){
                            freshCount--;
                            grid[neighborRow][neighborCol] = 2;
                            rottenQueue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }
        return freshCount == 0 ? minuteElapsed : -1;
    }
}
