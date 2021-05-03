package No201_250;

import java.util.ArrayDeque;

public class No224_BasicCalculator {

    public int calculate(String s) {
        int res = 0;
        if(s == null || s.length() == 0){
            return res;
        }
        ArrayDeque<Integer> signStack = new ArrayDeque<>();

        int num = 0;
        int sign = 1;
        signStack.push(sign);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else if(c == '+'){
                res += num * sign;
                sign = signStack.peek() * 1;
                num = 0;
            }else if(c == '-'){
                res += num * sign;
                sign = signStack.peek() * -1;
                num = 0;
            }else if(c == '('){
                signStack.push(sign);
            }else if(c == ')'){
                signStack.pop();
            }
        }

        res += num * sign;
        return res;
    }
}
