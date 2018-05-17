public class No11_ContainerWithMostWater {

    public static void main(String[] args){

    }

    public static int getMaxContainer(int[] heights){

        int start = 0;
        int end = heights.length - 1;
        int maxContainer = 0;

        while(start < end){
            maxContainer = Math.max(maxContainer, Math.min(heights[start], heights[end]) * (end - start));
            if(heights[start] < heights[end]){
                start++;
            }else{
                end--;
            }
        }

        return maxContainer;
    }


}
