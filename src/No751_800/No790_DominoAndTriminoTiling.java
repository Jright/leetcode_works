package No751_800;

public class No790_DominoAndTriminoTiling {

    public int numTilings(int n) {

        if(n <= 2){
            return n;
        }

        long[] f = new long[n + 1];
        long[] p = new long[n + 1];

        f[1] = 1L;
        f[2] = 2L;
        p[2] = 1L;

        int mod = 1_000_000_007;

        for(int index = 3; index < n + 1; index++){
            f[index] = (f[index - 1] + f[index - 2] + 2 * p[index - 1]) % mod;
            p[index] = (p[index - 1] + f[index - 2]) % mod;
        }

        return (int) (f[n]);
    }
}
