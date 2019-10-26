package No151_200;

public class No191_Numberof1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;

        for(int i = 0; i < 32; i++){
            if(n == 0){
                break;
            }
            if((n & 1) == 1){
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}
