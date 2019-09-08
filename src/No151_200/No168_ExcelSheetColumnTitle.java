package No151_200;

public class No168_ExcelSheetColumnTitle {

    // Copied from: https://blog.csdn.net/catttbao/article/details/69935990
    public static String convertToTitle(int n) {

        if (n <= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        while(n > 0){

            n--; // 1 - A, 2 - B, 3 - C ...

            // We calculate the last element first.
            sb.insert(0,(char)('A' + n % 26));

            // Moving to next digit (in this base-26 system)
            n = n / 26;

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 701;
        String s = convertToTitle(n);
        System.out.println(s);
    }

}
