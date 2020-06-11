package No51_100;

public class No75_SortColors {

    public void sortColors(int[] nums) {
        if(nums.length <= 1){
            return;
        }

        int zeroRight = 0;
        int twoLeft = nums.length - 1;

        for(int i = 0; i <= twoLeft; i++){
            if(nums[i] == 0){
                swap(nums, i, zeroRight);
                zeroRight++;
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, twoLeft);
                twoLeft--;
            }else{
                i++;
            }
        }

    }

    private void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

//    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3};
//        swap(array, 0, 2);
//        System.out.println(array[2]);
//    }

}
