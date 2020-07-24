package No251_300;

public class No260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums){
            bitmask ^= num;
        }

        int x = 0;

        int target = bitmask & (-bitmask);

        for(int num : nums){
            if((num & target) != 0){
                x = x ^ num;
            }
        }

        return new int[]{x, x ^ bitmask};
    }
}
