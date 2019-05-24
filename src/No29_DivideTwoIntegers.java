//TODO Questionable answer
public class No29_DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        int mod = dividend % divisor;
        int div = dividend - mod;

        int result = div / divisor;

        if(result > Math.pow(2, 31) - 1 || result < -Math.pow(2, 31)){
            return (int) Math.pow(2, 31) - 1;
        }


        return result;
    }

    public static void main(String[] args) {
        int i = -2;
        int j = -1;
        int divide = divide(i, j);
    }
}
