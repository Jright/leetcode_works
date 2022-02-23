package No151_200;

public class No171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;

        for(int index = columnTitle.length() - 1; index >= 0; index--){
            char c = columnTitle.charAt(index);
            res += (c - 'A' + 1) * ((int) Math.pow(26, columnTitle.length() - 1 - index));
        }

        return res;
    }
}
