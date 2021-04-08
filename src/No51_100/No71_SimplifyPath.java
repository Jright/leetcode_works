package No51_100;

import java.util.ArrayDeque;

public class No71_SimplifyPath {

    public String simplifyPath(String path) {

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] split = path.split("/");

        for(String item : split){
            if(item.equals("..")){
                if(stack.isEmpty()){
                    stack.push("/");
                }else{
                    stack.pop();
                }
            }else if(item.equals("/")){
                stack.push("/");
            }else if(item.equals(".")){
                continue;
            }else if(!item.isEmpty()){
                stack.push(item);
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            String s = stack.pop();
            builder.insert(0, s);
            if(!s.equals("/") && !builder.toString().startsWith("/")){
                builder.insert(0, "/");
            }
        }
        String b = builder.toString();
        String replace = b.replace("//", "/");
        if(replace.length() == 0){
            replace = "/";
        }
        return replace;
    }
}
