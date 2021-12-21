package No1051_1100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class No1091_ShortestPathInBinaryMatrix {

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }

            for (int[] neighbors : getNeighbors(row, col, grid)) {
                int neighborRow = neighbors[0];
                int neighborCol = neighbors[1];
                queue.add(new int[]{neighborRow, neighborCol});
                grid[neighborRow][neighborCol] = distance + 1;
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int index = 0; index < directions.length; index++) {
            int newRow = row + directions[index][0];
            int newCol = col + directions[index][1];

            if (newRow < 0 || newCol < 0 || newRow >= grid.length ||
                    newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbors.add(new int[]{newRow, newCol});
        }
        return neighbors;
    }
}
