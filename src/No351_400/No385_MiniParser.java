package No351_400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class No385_MiniParser {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }

        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        int sign = 1;
        ArrayDeque<NestedInteger> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(new NestedInteger());
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num = num * sign;
                if (!stack.isEmpty()) {
                    stack.peek().add(new NestedInteger(num));
                } else {
                    stack.push(new NestedInteger(num));
                }
                sign = 1;
            } else if (s.charAt(i) == ']' && stack.size() > 1) {
                NestedInteger ni = stack.pop();
                stack.peek().add(ni);
            } else if (s.charAt(i) == '-') {
                sign = -1;
            }
        }

        return stack.isEmpty() ? new NestedInteger() : stack.pop();
    }

    class NestedInteger {

        boolean isInteger;
        int integer;
        List<NestedInteger> list = new ArrayList<>();

        // Constructor initializes an empty nested list.
        public NestedInteger(){

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value){

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){
            return this.list.isEmpty();
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return integer;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){
            this.integer = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){
            this.list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return this.list;
        }
    }
}
