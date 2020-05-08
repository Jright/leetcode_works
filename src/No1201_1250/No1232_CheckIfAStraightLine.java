package No1201_1250;

public class No1232_CheckIfAStraightLine {
    public boolean checkStraightLine(int[][] arr) {
        if(arr == null || arr.length < 3 || arr[0].length == 0) return false;

        int[] p = arr[0];
        int[] q = arr[1];

        for(int i = 2; i < arr.length; i++) {
            int[] curr = arr[i];

            if((curr[0] - p[0]) * (q[1] - p[1]) != (curr[1] - p[1]) * (q[0] - p[0])) return false;
        }

        return true;
    }
}
