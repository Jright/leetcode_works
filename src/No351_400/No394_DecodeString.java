package No351_400;

import java.util.ArrayDeque;

public class No394_DecodeString {
    public static String decodeString(String s) {
        if(s == null && s.length() == 0){
            return s;
        }
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> sbStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                int k = i + 1;
                while(k < s.length() && Character.isDigit(s.charAt(k))){
                    num = num * 10 + (s.charAt(k) - '0');
                    i = k;
                    k++;
                }
                numStack.push(num);
            }else if(s.charAt(i) == '['){
                sbStack.push(sb);
                sb = new StringBuilder();
            }else if(s.charAt(i) == ']'){
                int repeat = numStack.pop();
                String repeatString = sb.toString();
                for(int j = 0; j < repeat - 1; j++){
                    sb.append(repeatString);
                }
                if(!sbStack.isEmpty()){
                    StringBuilder prevBuilder = sbStack.pop();
                    prevBuilder.append(sb);
                    sb = prevBuilder;
                }
            }else if(Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String res = decodeString(s);
        System.out.printf(res);
    }
}
