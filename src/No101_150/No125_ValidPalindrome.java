package No101_150;

public class No125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return true;
        }

        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }else if (!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else{
                if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
                    l++;
                    r--;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
