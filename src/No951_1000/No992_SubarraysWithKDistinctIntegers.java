package No951_1000;

public class No992_SubarraysWithKDistinctIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;

        // record each number's occurance
        int[] m = new int[A.length + 1];

        for (int right = 0, left = 0, count = 0; right < A.length; right++) {
            // if the current index's number in A[] is distinct
            // (not shown in m[] array), add 1 to the distinct
            // count
            // note that even if it is not 0, it should plus one.
            if (m[A[right]] == 0) {
                count++;
            }
            m[A[right]]++;

            // if the current distinct number count is greater than
            // (desired) K
            if (count > K) {
                // remove 1 of the value A[left] inside m[]
                m[A[left]]--;
                // move left 1 step to the right
                left++;
                // reduce count by 1, because of the next while loop would always
                // start the window with an unique character
                count--;
                // reset prefix to 0, because:
                // resetting of prefix to 0 is necessary because now every POTENTIAL candidate
                // we kept record of previously can no longer be a potential candidate
                // in this new window. This is because those candidates will all contain > K
                // distinct integers in the new window
                prefix = 0;
            }

            // while A[left] is not unique...
            while (m[A[left]] > 1) {
                // treat this A[left] as 1 more prefix
                prefix++;
                // reduce 1 occurance of A[left]
                m[A[left]]--;
                // move left 1 step right
                left++;
            }

            // finally, we check if this count number is exactly K
            // and apply this formula
            if (count == K) {
                res += prefix + 1;
            }
        }
        return res;
    }
}
