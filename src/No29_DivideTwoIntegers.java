public class No29_DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {

        // Integer.MIN_VALUE divides with -1 would cause overflow...
        if(dividend == Integer.MIN_VALUE){
            if(divisor == 1){
                return Integer.MIN_VALUE;
            }else if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }

        int result = 0;

        // Would the result be negative or not.
        boolean negative = false;

        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            negative = true;
        }

        // Transform the two numbers as negative, so inside the calculation
        // process there would not be overflow
        if(dividend > 0){
            dividend = -dividend;
        }

        if(divisor > 0){
            divisor = -divisor;
        }

        // according to the question's description
        // we cannot use long or any form of data that is
        // bigger than 32-bit signed integer.
        int[] divisorArray = new int[32];
        int index = 0;
        divisorArray[index] = divisor;

        // Initialize the divisor's array
        // for later use
        while(dividend - divisorArray[index] <= divisorArray[index]){
            divisorArray[index + 1] = divisorArray[index] * 2;
            index++;
        }

        // Subtract till the dividend becomes positive.
        for(int i = index; i >= 0; i--){
            if(dividend - divisorArray[i] <= 0){
                result += (1 << i);
                dividend -= divisorArray[i];
            }
        }

        // Decide the sign in last step.
        return negative ? -result : result;

    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        int j = 1;
        int divide = divide(i, j);
        System.out.println(divide);
    }
}
