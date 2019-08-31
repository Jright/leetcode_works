package No1_50;

import java.util.*;

public class No3_LongestUnrepeatedSubstring {

    public static void main(String[] args){
        String s = "awawhilea";
        int i = lengthOfLongestSubstring(s);
        System.out.print(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        //In the beginning I thought it should be a map with sorted key(TreeMap, LinkedHashmap), but it is unnecessary.
        //We just have to figure out, with the runner pointer, to check the distance between founded same char.
        Map<Character,Integer> map = new HashMap<>();
        int answer= 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            answer = Math.max(answer, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return answer;
    }
}
