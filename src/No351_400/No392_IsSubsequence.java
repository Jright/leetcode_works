package No351_400;

public class No392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        if(t.length() == 0){
            return false;
        }

        if(s.length() > t.length()){
            return false;
        }

        int tPointer = 0;

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            int locateIndex = t.indexOf(sChar);
            if(locateIndex == -1){
                return false;
            }

            tPointer = locateIndex;
            t = t.substring(tPointer + 1);
        }

        return true;
    }

}
