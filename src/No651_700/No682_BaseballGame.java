package No651_700;

import java.util.ArrayDeque;
import java.util.Deque;

public class No682_BaseballGame {
    public int calPoints(String[] ops) {
        int res = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for(String item: ops){
            if(item.equals("C")){
                stack.pop();
            }else if(item.equals("D")){
                int num = 2 * stack.peek();
                stack.push(num);
            }else if(item.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                int c = a + b;
                stack.push(a);
                stack.push(b);
                stack.push(c);
            }else{
                int num = Integer.parseInt(item);
                stack.push(num);
            }
        }

        while(!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }
}
