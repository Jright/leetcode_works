package No701_750;

import java.util.Arrays;

public class No706_DesignHashmap {

    Integer[] arr;
    int size = 10;

    public No706_DesignHashmap() {
        arr = new Integer[size];
        Arrays.fill(arr, null);
    }

    public void put(int key, int value) {
        if(key > size - 1){
            Integer[] arrTemp = new Integer[key + 1];
            for(int index = 0; index < arr.length; index++){
                arrTemp[index] = arr[index];
            }
            size = key + 1;
            arr = arrTemp;
        }
        arr[key] = value;
    }

    public int get(int key) {
        if(key > size - 1){
            return -1;
        }
        return arr[key] == null ? -1 : arr[key];
    }

    public void remove(int key) {
        if(key > size - 1){
            return;
        }
        arr[key] = null;
    }
}
