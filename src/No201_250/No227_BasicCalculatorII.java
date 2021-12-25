package No201_250;

import java.util.ArrayDeque;

public class No227_BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char operator = '+';
        int lastNumber = 0;
        int currentNumber = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                currentNumber = currentNumber * 10 + (curr - '0');
            }

            if (!Character.isDigit(curr) && !Character.isWhitespace(curr) || i == s.length() - 1) {
                if (operator == '+') {
                    res += lastNumber;
                    lastNumber = currentNumber;
                } else if (operator == '-') {
                    res += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operator == '*') {
                    lastNumber *= currentNumber;
                } else if (operator == '/') {
                    lastNumber /= currentNumber;
                }
                operator = curr;
                currentNumber = 0;
            }
        }

        res += lastNumber;
        return res;
    }
}
