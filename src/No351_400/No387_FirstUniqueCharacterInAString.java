package No351_400;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class No387_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {

        if(s.length() == 0){
            return -1;
        }

        if(s.length() == 1){
            return 0;
        }

//        Map<Character, Integer> map = new LinkedHashMap<>();
//
//        for(int i = 0; i < s.length(); i++){
//            int occurance = map.getOrDefault(s.charAt(i), 0);
//
//            map.put(s.charAt(i), occurance + 1);
//        }
//
//        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Character, Integer> next = iterator.next();
//            if(next.getValue() == 1){
//                return s.indexOf(next.getKey());
//            }
//        }

        int[] letters = new int[26];

        for(int i = 0; i < s.length(); i++){
            letters[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(letters[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
