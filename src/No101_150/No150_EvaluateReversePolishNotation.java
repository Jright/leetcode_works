package No101_150;

import java.util.ArrayDeque;

public class No150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < tokens.length; i++){
            if(isInteger(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                if(stack.size() < 2){
                    continue;
                }
                int num1 = stack.pop();
                int num2 = stack.pop();
                int temp = 0;
                if(tokens[i].equals("+")){
                    temp = num1 + num2;
                }else if(tokens[i].equals("-")){
                    temp = num2 - num1;
                }else if(tokens[i].equals("*")){
                    temp = num1 * num2;
                }else if(tokens[i].equals("/")){
                    temp = num2 / num1;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public boolean isInteger(String strNum) {
        if (strNum == null || strNum.length() == 0) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
