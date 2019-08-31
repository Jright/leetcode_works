package No1_50;

public class No27_RemoveElement {


    public static int removeElement(int[] nums, int val){
        if(nums.length == 0){
            return 0;
        }
        int key = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == val){ // Amazing idea by GeekSu (Leetcode)
                // https://leetcode.com/problems/remove-element/discuss/291576/I-think-this-is-easy-to-understand(Java)
                continue;
            }else{
                nums[key]=nums[i];
                key++;
            }
        }
        return key;
    }

//    public static int removeElement(int[] nums, int val) {
//        int original_length = nums.length;
//
//        int val_count = 0;
//
//        if(original_length == 0){
//            return 0;
//        }
//
//        int start = 0;
//        int end = original_length - 1;
//        for (; start <= end; start++){
//            if(nums[start] == val){
//                val_count++;
//
//                while(end > start){
//                    if(nums[end] == val){
//                        val_count++;
//                        end--;
//                    }else{
//                        swapElement(nums, start, end);
//                        end--;
//                        break;
//                    }
//                    if(end == start + 1 || end == start){
//                        return (original_length - val_count);
//                    }
//                }
//            }
//        }
//        return (original_length - val_count);
//
//    }
//
//    private static void swapElement(int[] nums, int a, int b){
//        int temp;
//        temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }

    public static void main(String[] args) {
        int[] test = new int[]{1};
        int result = removeElement(test, 1);
        System.out.println(result);
        for(int num : test){
            System.out.print(num + " ");
        }
    }

}
