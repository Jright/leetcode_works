package No51_100;

import java.util.ArrayList;
import java.util.List;

public class No54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (resList.size() < rows * columns) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                resList.add(matrix[up][col]);
            }

            // Traverse downwards.
            for (int row = up + 1; row <= down; row++) {
                resList.add(matrix[row][right]);
            }

            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    resList.add(matrix[down][col]);
                }
            }

            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    resList.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return resList;
    }
}
