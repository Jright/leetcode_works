public class No7_ZigZagConversion {


    public static void main(String[] args) {
        String string = "12345678";
        int rows = 3;
        String convert = convert(string, rows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        //Every row is an element of the StringBuilder array
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");   //init every sb element **important step!!!!
        }

        int incre = 1;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) {
                incre = 1;
            }
            if (index == numRows - 1) {
                incre = -1;
            }
            index += incre;
        }

        StringBuilder re = new StringBuilder();
        for (StringBuilder aSb : sb) {
            re.append(aSb);
        }

        return re.toString();
    }

}
