
//Given a 32-bit signed integer, reverse digits of an integer.
//
//        Example 1:
//
//        Input: 123
//        Output: 321
//        Example 2:
//
//        Input: -123
//        Output: -321
//        Example 3:
//
//        Input: 120
//        Output: 21
//        Note:
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//

public class No7_ReverseInteger {

    public static void main(String[] args){
        int x = 117;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    public static int reverse(int x){
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x == 0){
            return 0;
        }

        if(x < 10 && x > -10){
            return x;
        }

        long result = 0;
        while (x != 0){
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        if (result > Integer.MIN_VALUE && result < Integer.MAX_VALUE){
            return (int)result;
        } else{
            return 0;
        }

    }

}
