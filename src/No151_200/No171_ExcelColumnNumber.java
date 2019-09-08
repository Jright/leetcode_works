package No151_200;

public class No171_ExcelColumnNumber {

    public static int titleToNumber(String s) {

        int result = 0;

        if(s == null || s.length() == 0){
            return result;
        }

        int digit = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            int number = s.charAt(i) - 'A' + 1;
            result += number * digit;
            digit = digit * 26;
        }

        return result;
    }

    public static void main(String[] args) {

        int zy = titleToNumber("ZY");
        System.out.println(zy);
    }

}
