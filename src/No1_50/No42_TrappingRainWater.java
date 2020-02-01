package No1_50;

public class No42_TrappingRainWater {

    public int trap(int[] height) {

        int i = 0;
        int j = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        while(i < j){
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if(leftMax < rightMax){
                result += (leftMax - height[i]);
                i++;
            }else{
                result += (rightMax + height[j]);
                j--;
            }
        }
        return result;
    }

}
