package No1_50;

import java.util.*;

public class No49_GroupAnagrams {

    // TODO Using the understanding of hash algorithm.
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            if(map.containsKey(key)){
                List<String> value = map.get(key);
                value.add(str);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> next : map.entrySet()) {
            result.add(next.getValue());
        }
        return result;
    }

}
