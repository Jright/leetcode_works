package No651_700;

public class No680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return (verifyPalindrome(s, left, right - 1) || verifyPalindrome(s, left + 1, right));
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean verifyPalindrome(String s, int left, int right){
        if(s == null || s.length() <= 1){
            return true;
        }

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
