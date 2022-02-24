package No151_200;

import java.util.ArrayDeque;

public class No151_ReverseWordInAString {
    public String reverseWords(String s) {
        StringBuilder wordBuilder = new StringBuilder();
        StringBuilder resBuilder = new StringBuilder();
        char[] array = s.toCharArray();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] split = s.split(" ");
        for(int index = 0; index < split.length; index++){
            if(split[index].trim().length() > 0){
                stack.push(split[index]);
            }
        }

        while(!stack.isEmpty()){
            String item = stack.pop();
            for(int index = 0; index < item.length(); index++){
                if(item.charAt(index) != ' '){
                    wordBuilder.append(item.charAt(index));
                }
            }
            resBuilder.append(wordBuilder.toString());
            wordBuilder = new StringBuilder();
            if(stack.size() > 0){
                resBuilder.append(" ");
            }
        }

        return resBuilder.toString();
    }
}
