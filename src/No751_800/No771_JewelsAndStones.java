package No751_800;

import java.util.HashSet;
import java.util.Set;

public class No771_JewelsAndStones {

    public int numJewelsInStones(String J, String S) {

        if(J.length() == 0 || S.length() == 0){
            return 0;
        }

        int result = 0;

        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        for(char s : S.toCharArray()){
            if(set.contains(s)){
                result++;
            }
        }

        return result;
    }

}
