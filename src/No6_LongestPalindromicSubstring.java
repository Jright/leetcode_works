/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 */
public class No6_LongestPalindromicSubstring {

    private static int maxLeft = 0;
    private static int maxRight = 0;

    public static void main(String[] args){
        String s = "abbawsidwdisw";
        String result = getLongestPalindromicSubString(s);
        System.out.println("The result is: " + result);
    }

    private static String getLongestPalindromicSubString(String string){

        for(int i = 0; i < string.length(); i++){
            int oddDistance = getLongestDistance(string, i, i);// If the size number of string is odd, so the palindromic center should be a element of this char array
            int evenDistance = getLongestDistance(string, i, i + 1);//The size of string is even. The center is between two chars.

            int len = Math.max(oddDistance, evenDistance);
            if (len > maxRight - maxLeft) {
                maxLeft = i - (len - 1) / 2;
                maxRight = i + len / 2;
            }
        }

        return string.substring(maxLeft, maxRight + 1);

    }

    private static int getLongestDistance(String string, int left, int right){

        while(left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;

    }
}
