package No201_250;

public class No231_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }

        int oneCount = 0;

        while(n > 0){
            int lastItem = n & 1;
            if(lastItem == 1){
                oneCount++;
            }
            n = n >> 1;
        }

        return oneCount == 1;
    }
}
