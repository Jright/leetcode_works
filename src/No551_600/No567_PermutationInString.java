package No551_600;

import java.util.Arrays;

public class No567_PermutationInString {

    public boolean checkInclusion(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()){
            return false;
        }

        int[] s1Array = new int[26];
        int[] permuteArray = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++){
            permuteArray[s2.charAt(i) - 'a']++;

            if(i >= s1.length()){
                permuteArray[s2.charAt(i - s1.length()) - 'a']--;
            }

            if(Arrays.equals(s1Array, permuteArray)){
                return true;
            }
        }
        return false;
    }
}
