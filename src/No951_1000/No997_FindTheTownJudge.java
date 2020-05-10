package No951_1000;

public class No997_FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {
        if(N == 0){
            return -1;
        }

        int[] a = new int[N + 1];
        int[] b = new int[N + 1];

        for (int[] ints : trust) {
            a[ints[1]]++;
            b[ints[0]]++;
        }

        for(int i = 1; i < N + 1; i++){
            if(a[i] == N - 1){
                if(b[i] == 0){
                    return i;
                }
            }
        }

        return -1;
    }

}
