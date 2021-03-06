package No1_50;

public class No9_PalindromeNumber {

    public static void main(String[] args){

        System.out.println("isPalndrome: " + isPalindrome(12721));

    }

    public static boolean isPalindrome(int x) {

        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int halfReverseNum = 0;

        while(halfReverseNum < x){
            halfReverseNum = halfReverseNum * 10 + x % 10;
            x = x / 10;
        }

        System.out.println("halfReverseNum: " + halfReverseNum + ",x: " + x);

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == halfReverseNum || x == halfReverseNum / 10;

    }



}
