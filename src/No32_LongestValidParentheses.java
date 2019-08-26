import java.util.Stack;

public class No32_LongestValidParentheses {
    // 1. Should be a O(n) problem.
    // 2. Using stack to store the "(", pop the stack when it is ")"
    // 3. There should be two int variable, one for storing the
    // longest value for now, one for storing the current length,
    public static int longestValidParentheses(String s) {
        // Corner case
        if(s.length() == 0){
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Dummy item... fit with later logic.

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i); // Record the index of '('
            }else{
                // For the first time reaches it, the -1 is used to pop out.
                stack.pop();
                // If there is still number inside the stack
                // means we found the last '(' or ')' that cannot fit with
                // a ')'
                if(!stack.isEmpty()){
                    // Think about the '-1' now...
                    // When i = 1, and the two elements are '(' and ')'
                    result = Math.max(result, i - stack.peek());
                }else{ // Or, the stack is already empty, then we just push this index (that
                    // might be used for later calculation.
                    stack.push(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "()(()";
        int i = longestValidParentheses(s);
        System.out.println("The result is: " + i);
    }
}
