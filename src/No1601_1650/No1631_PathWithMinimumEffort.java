package No1601_1650;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1631_PathWithMinimumEffort {

    int rows = 0;
    int cols = 0;

    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {{-1, 0},{1, 0},{0, 1}, {0, -1}};

        boolean[][] visited = new boolean[this.rows][this.cols];
        visited[0][0] = true;

        int newX = 0;
        int newY = 0;
        int[] curr;
        int currDiff = 0;
        int maxDiff = 0;
        int[][] diffMatrix = new int[rows][cols];

        for(int[] eachRow : diffMatrix){
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        }

        diffMatrix[0][0] = 0;

        while(!pq.isEmpty()){
            curr = pq.poll();
            visited[curr[0]][curr[1]] = true;
            if(curr[0] == rows - 1 && curr[1] == cols -1){
                return curr[2];
            }
            for(int[] direction: directions){
                newX = curr[0] + direction[0];
                newY = curr[1] + direction[1];
                if(isValidCell(newX, newY) && !visited[newX][newY]){
                    currDiff =  Math.abs(heights[curr[0]][curr[1]] -
                            heights[newX][newY]);
                    maxDiff = Math.max(currDiff, diffMatrix[curr[0]][curr[1]]);
                    if(maxDiff < diffMatrix[newX][newY]){
                        diffMatrix[newX][newY] = maxDiff;
                        pq.offer(new int[]{newX, newY, maxDiff});
                    }
                }
            }
        }

        return maxDiff;
    }

    private boolean isValidCell(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
