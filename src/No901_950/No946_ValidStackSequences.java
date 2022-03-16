package No901_950;

import java.util.ArrayDeque;

public class No946_ValidStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }
}
