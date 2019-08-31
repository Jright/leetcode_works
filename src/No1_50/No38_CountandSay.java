package No1_50;

public class No38_CountandSay {

    public String countAndSay(int n) {
        String res = "1";
        int index = 1;
        // Start from the 1st item.
        while (index < n) {
            String temp = "";
            for (int i = 0; i < res.length(); i++) {
                int num = getRepeatNum(res.substring(i));
                temp = temp + num + "" + res.charAt(i);
                // Skip the duplicated letters
                i = i + num - 1;
            }
            index++;
            // update the result after one loop
            res = temp;
        }
        return res;

    }

    // Get the repeated number of the fisrt char of a String，like "111221" returns 3.
    private int getRepeatNum(String string) {
        int count = 1;
        char same = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (same == string.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
