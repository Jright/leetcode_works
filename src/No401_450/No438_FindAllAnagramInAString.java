package No401_450;

import java.util.*;

public class No438_FindAllAnagramInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() == 0 || s.length() == 0 || s.length() < p.length()){
            return result;
        }

        int[] pLetters = new int[26];
        int[] readLetters = new int[26];

        for(int i = 0; i < p.length(); i++){
            pLetters[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            readLetters[s.charAt(i) - 'a']++;
            if(i >= p.length()){
                readLetters[s.charAt(i - p.length()) - 'a']--;
            }
            if(Arrays.equals(pLetters, readLetters)){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s, p);
    }
}
