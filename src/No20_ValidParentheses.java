import java.util.Stack;

public class No20_ValidParentheses {

    public boolean isValid(String s) {
//        ArrayList<Character> charList = new ArrayList<>();
//        char[] chars = s.toCharArray();
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        for(Character c : chars){
//
//            if(c.equals('[')){
//                charList.add(c);
//                i++;
//            }else if(c.equals('(')){
//                charList.add(c);
//                j++;
//            }else if(c.equals('{')){
//                charList.add(c);
//                k++;
//            }else if(c.equals(']')){
//                 if(!charList.contains('[')){
//                     return false;
//                 }else{
//                    i--;
//                    if(i < 0){
//                        return false;
//                    }
//                 }
//            }else if(c.equals(')')){
//                if(!charList.contains('(')){
//                    return false;
//                }else{
//                    j--;
//                    if(j < 0){
//                        j = 0;
//                        return false;
//                    }
//                }
//            }else if(c.equals('}')){
//                if(!charList.contains('{')){
//                    return false;
//                }else{
//                    k--;
//                    if(k < 0){
//                        k = 0;
//                        return false;
//                    }
//                }
//            }else{
//                return false;
//            }
//        }
//        return true;

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


}
