package No51_100;

import java.util.ArrayDeque;
import java.util.Deque;

public class No84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        if(heights.length == 1){
            return heights[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;
        stack.push(-1);

        for(int index = 0; index < heights.length; index++){
            while(stack.peek() != -1 && (heights[stack.peek()] >= heights[index])){
                int currentHeight = heights[stack.pop()];
                int currentWidth = index - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(index);
        }

        while(stack.peek() != -1){
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }
}
