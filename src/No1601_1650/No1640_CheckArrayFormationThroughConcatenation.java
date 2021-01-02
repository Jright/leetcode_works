package No1601_1650;

import java.util.HashMap;
import java.util.Map;

public class No1640_CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        if(pieces == null || pieces.length == 0){
            return false;
        }
        Map<Integer, int[]> map = new HashMap<>();

        for(int[] a: pieces){
            map.put(a[0], a);
        }

        for(int i = 0; i < arr.length;){
            if(map.containsKey(arr[i])){
                int[] valueArr = map.get(arr[i]);
                int mark = i;
                for(int j = 0; j < valueArr.length; j++, i++){
                    if(arr[i] != valueArr[j]){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
