package No1301_1350;

import java.util.HashSet;
import java.util.Set;

public class No1346_CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length <= 1){
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for(int num: arr){
            if(set.contains(num * 2)){
                return true;
            }else if(num % 2 == 0 && set.contains(num / 2)){
                return true;
            }else{
                set.add(num);
            }
        }

        return false;
    }
}
