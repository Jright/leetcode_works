public class No8_StringToInteger {


    public static void main(String[] args) {
        int beauty = myAtoi("-91283472332");
        System.out.println(beauty);
    }

    public static int myAtoi(String str) {

        long result = 0;

        int n = str.length();

        boolean negative = false;
        boolean positive = false;

        // whether there is a leading zero
        boolean leading_zero = false;


        // whether a/some digit(s) has been counted already.
        boolean verify = false;

//        boolean content = false;
        boolean exceeded = false;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (verify || negative || positive) {
                    break;
                } else {
                    continue;
                }
            }

            if (c == '+') {
                if (verify || negative || positive) {
                    break;
                }
                positive = true;
                continue;
            }

            if (c == '-') {
                if (negative || verify || positive) {
                    break;
                }
                negative = true;
                continue;
            }

            if (c < '0' || c > '9') {
                break;
            }

            if (c == '0' && !verify) {
                leading_zero = true;
            } else {
                verify = true;
            }

            result = result * 10 + (c - '0');
            verify = true;

            if (result >= (1L << 31)) {
                result = negative ? (1L << 31) : (1L << 31) - 1;
            }
        }
        return negative ? (int) -result : (int) result;
    }
}
