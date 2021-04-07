package No1_50;

import java.util.ArrayDeque;

public class No20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
