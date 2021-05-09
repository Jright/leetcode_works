package No301_350;

import java.util.ArrayDeque;
import java.util.Stack;

public class No316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        char head = 'z';
        int[] occur = new int[26];
        boolean[] visited = new boolean[26];
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            occur[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(visited[c - 'a']){
                continue;
            }
            occur[c - 'a']--;
            while(!stack.isEmpty() && stack.peek() > c && occur[c - 'a'] > 0){
                visited[c - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }


        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
