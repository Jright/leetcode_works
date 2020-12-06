package No951_1000;

import java.util.Arrays;

public class No977_SquaresOfSortedArray {

    public int[] sortedSquares(int[] A) {
        if(A.length == 0){
            return new int[0];
        }

        if(A[0] >= 0 ){

            for(int i = 0; i < A.length; i++){
                A[i] = A[i] * A[i];
            }
            return A;
        }

        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);

        return A;
    }
}
