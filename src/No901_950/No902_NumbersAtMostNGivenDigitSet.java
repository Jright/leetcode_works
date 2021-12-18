package No901_950;

public class No902_NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String string = String.valueOf(n);
        int stringLength = string.length();

        int[] dp = new int[stringLength + 1];
        dp[stringLength] = 1;

        for(int index = stringLength - 1; index >= 0; index--){
            int charIndex = string.charAt(index) - '0';
            for(String digit: digits){
                if(Integer.valueOf(digit) < charIndex){
                    dp[index] += Math.pow(digits.length, stringLength - index - 1);
                }else if(Integer.valueOf(digit) == charIndex){
                    dp[index] += dp[index + 1];
                }
            }
        }

        for(int index = 1; index < stringLength; index++){
            dp[0] += Math.pow(digits.length, index);
        }

        return dp[0];
    }
}
