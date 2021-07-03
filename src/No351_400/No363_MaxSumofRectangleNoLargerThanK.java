package No351_400;

public class No363_MaxSumofRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for(int left = 0; left < cols; left++){
            int[] rowSum = new int[rows];
            for(int right = left; right < cols; right++){
                for (int index = 0; index < rows; index++) {
                    rowSum[index] += matrix[index][right];
                }
                max = Math.max(max, dpMax(rowSum, k));
            }
        }

        return max;
    }

    private int dpMax(int[] arr, int k){
        int rollSum = arr[0], rollMax = rollSum;
        for (int index = 1; index < arr.length; index++) {
            if (rollSum > 0){
                rollSum += arr[index];
            }
            else {
                rollSum = arr[index];
            }
            if (rollSum > rollMax) {
                rollMax = rollSum;
            }
        }
        if (rollMax <= k) {
            return rollMax;
        }
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < arr.length; index++) {
            int sum = 0;
            for (int r = index; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                if (max == k){
                    return k;
                }
            }
        }
        return max;
    }
}
