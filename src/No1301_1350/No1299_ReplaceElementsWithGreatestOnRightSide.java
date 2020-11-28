package No1301_1350;

public class No1299_ReplaceElementsWithGreatestOnRightSide {

    public int[] replaceElements(int[] arr) {
        if(arr == null || arr.length == 0){
            return arr;
        }

        if(arr.length == 1){
            return new int[]{-1};
        }

        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }

}
