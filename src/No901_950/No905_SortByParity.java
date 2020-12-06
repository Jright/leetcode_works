package No901_950;

public class No905_SortByParity {

    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length <= 1){
            return A;
        }

        int a = 0;
        int b = A.length - 1;

        while(a < b){
            if(A[a] % 2 == 1 && A[b] % 2 == 0){
                int temp = A[a];
                A[a] = A[b];
                A[b] = temp;
            }

            if(A[a] % 2 == 0){
                a++;
            }

            if(A[b] % 2 == 1){
                b--;
            }
        }

        return A;

    }
}
