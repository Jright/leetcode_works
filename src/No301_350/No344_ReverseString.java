package No301_350;

public class No344_ReverseString {

    public void reverseString(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
