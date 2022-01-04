package No1001_1050;

public class No1009_ComplementOfABase10Integer {
    public int bitwiseComplement(int N) {
        if(N == 0){
            return 1;
        }

        int res = 0;
        int count = 0;
        int digit = 0;

        while(N != 0){
            digit = N & 1;
            digit = digit == 1 ? 0 : 1;

            digit = digit << count;
            res += digit;
            N = N >> 1;
            count++;
        }
        return res;
    }
}
