package No201_250;

import java.util.ArrayDeque;

public class No227_BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        char operator = '+';
        int currentNum = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                currentNum = currentNum * 10 + (curr - '0');
            }

            if (!Character.isDigit(curr) && !Character.isWhitespace(curr) || i == s.length() - 1) {
                if (operator == '+') {
                    numStack.push(currentNum);
                } else if (operator == '-') {
                    numStack.push(-currentNum);
                } else if (operator == '*') {
                    numStack.push(numStack.pop() * currentNum);
                } else if (operator == '/') {
                    numStack.push(numStack.pop() / currentNum);
                }
                operator = curr;
                currentNum = 0;
            }
        }

        while(!numStack.isEmpty()){
            res += numStack.pop();
        }
        return res;
    }
}
