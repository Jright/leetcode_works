package No1001_1050;

import java.util.HashSet;
import java.util.Set;

public class No1015_SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        for(int index = 1; index <= k; index++){
            remainder = (remainder * 10 + 1) % k;
            if(remainder == 0){
                return index;
            }
        }
        return -1;
    }
}
