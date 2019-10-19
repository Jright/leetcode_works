package No1_50;

public class No43_MultiplyStrings {

    public String multiply(String num1, String num2) {

        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();

        int[] result = new int[num1CharArray.length + num2CharArray.length];

        for (int i = 0; i < num1CharArray.length; i++) {
            for (int j = 0; j < num2CharArray.length; j++) {
                int multiply = (num1CharArray[i] - '0') * (num2CharArray[j] - '0');

                // Leading zeros instead of trailing zeros, because it is easier to handle with.
                result[i + j + 1] += multiply;
            }
        }

        int carry = 0;
        for (int k = result.length - 1; k >= 0; k--) {

            int number = (result[k] + carry) % 10;

            carry = (result[k] + carry) / 10;

            result[k] = number;
        }

        StringBuilder sb = new StringBuilder();

        for(int integer : result){
            sb.append(integer);
        }

        while(sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
