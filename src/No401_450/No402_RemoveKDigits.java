package No401_450;

import java.util.ArrayDeque;

public class No402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k <= 0) {
            return num;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();

        int cap = num.length() - k;
        int leftOver = num.length();

        for (int i = 0; i < num.length(); i++) {
            leftOver = num.length() - i;
            int numValue = num.charAt(i) - '0';
            char numItem = num.charAt(i);
            while (!stack.isEmpty() && numValue < stack.peek() - '0'
                    && (leftOver + stack.size() - 1) >= cap) {
                stack.pop();
            }
            if(stack.size() < cap){
                stack.push(numItem);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }

        String temp = sb.toString();
        sb = new StringBuilder();
        boolean firstNonZeroFound = false;
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) - '0' != 0){
                firstNonZeroFound = true;
            }

            if(!firstNonZeroFound){
                if(temp.charAt(i) - '0' != 0){
                    sb.append(temp.charAt(i));
                }
            }else{
                sb.append(temp.charAt(i));
            }
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
