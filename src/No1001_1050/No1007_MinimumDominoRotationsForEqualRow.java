package No1001_1050;

public class No1007_MinimumDominoRotationsForEqualRow {
    public int minDominoRotationsOptimized(int[] tops, int[] bottoms) {
        //hold count of elements of top array
        int[] countA = new int[7];
        //hold count of elements of bottom array
        int[] countB = new int[7];
        //hold count of elements which appeared in both array.
        int[] same = new int[7];
        //length of array
        int n = tops.length;
        //iterate each element and prepare countA, countB and same frequencies
        for (int i = 0; i < n; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        //iterate from i=1 till 6.
        for (int i = 1; i < 7; i++) {
            //check for any value of i if total occurrence==n
            if (countA[i] + countB[i] - same[i] == n) {
                //if yes it means we have the answer which will be length minus maximum frequency of countA and countB.
                return n - Math.max(countA[i], countB[i]);
            }
        }
        //answer not possible
        return -1;
    }
}
