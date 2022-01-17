package No251_300;

import java.util.HashMap;
import java.util.Map;

public class No290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if(pattern.length() != split.length){
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int index = 0; index < split.length; index++){
            char key = pattern.charAt(index);
            String value = split[index];
            if(!map1.containsKey(key)){
                map1.put(key, value);
            }else{
                if(!map1.get(key).equals(value)){
                    return false;
                }
            }

            if(!map2.containsKey(value)){
                map2.put(value, key);
            }else{
                if(map2.get(value) != key){
                    return false;
                }
            }
        }
        return true;
    }
}
