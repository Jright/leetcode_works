package No901_950;

public class No941_ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length < 3){
            return false;
        }

        int i = 0;
        int j = arr.length - 1;

        while(i < arr.length - 1){
            if(arr[i] < arr[i + 1]){
                i++;
            }else{
                break;
            }
        }

        while(j > 0){
            if(arr[j] < arr[j - 1]){
                j--;
            }else{
                break;
            }
        }

        return (j - i <= 1 && i != 0 && j != arr.length - 1);
    }

}
