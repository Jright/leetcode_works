package No1601_1650;

import java.util.HashSet;
import java.util.Set;

public class No1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        if(s.length() <= 1){
            return 0;
        }

        int[] letters = new int[26];
        for(int index = 0; index < s.length();  index++){
            letters[s.charAt(index) - 'a']++;
        }

        int result = 0;
        Set<Integer> uniqueCount = new HashSet<Integer>();

        for(int index = 0; index < letters.length; index++){
            int val = letters[index];
            if(!uniqueCount.contains(val)){
                uniqueCount.add(val);
            }else {
                while(uniqueCount.contains(val) && val > 0){
                    val--;
                    result++;
                }
                uniqueCount.add(val);
            }
        }
        return result;
    }
}
