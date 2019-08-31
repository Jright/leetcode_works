package No51_100;

public class No58_LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        int tail = s.length() - 1;

        while (tail >= 0 && s.charAt(tail) == ' ') {
            tail--;
        }

        while(tail >= 0 && s.charAt(tail) != ' '){
            tail--;
            length++;
        }
        return length;
    }

}
