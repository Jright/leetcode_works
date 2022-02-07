package No351_400;

public class No389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }

        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for(int index = 0; index < s.length(); index++){
            arrS[s.charAt(index) - 'a']++;
        }

        for(int index = 0; index < t.length(); index++){
            arrT[t.charAt(index) - 'a']++;
        }

        for(int index = 0; index < arrS.length; index++){
            if(arrS[index] != arrT[index]){
                return (char) ('a' + index);
            }
        }

        return '/';
    }
}
