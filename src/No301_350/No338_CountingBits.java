package No301_350;

public class No338_CountingBits {

    public int[] countingBits(int num){
        int[] ans = new int[num + 1];

        for(int i = 1; i <= num; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
