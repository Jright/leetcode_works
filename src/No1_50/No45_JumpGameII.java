package No1_50;

// Copied answer from
// https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
public class No45_JumpGameII {

    public int jump(int[] nums) {

        int currentMaxDistance = 0;
        int currentEnd = 0;
        int steps = 0;

        for(int i = 0; i < nums.length - 1; i++){

            // Draw on paper, then you will see this is actually a BFS search.
            currentMaxDistance = Math.max(currentMaxDistance, i + nums[i]);

            if(i == currentEnd){
                steps++;
                currentEnd = currentMaxDistance;
            }
        }
        return steps;

    }

}