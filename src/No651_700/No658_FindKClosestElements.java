package No651_700;

import java.util.ArrayList;
import java.util.List;

public class No658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - k;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int index = left; index < left + k; index++){
            result.add(arr[index]);
        }

        return result;
    }
}
