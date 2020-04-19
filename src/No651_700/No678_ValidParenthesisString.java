package No651_700;

public class No678_ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            low += c == '(' ? 1 : -1;
            high += c != ')' ? 1 : -1;
            if (high < 0) {
                return false;
            }

            low = Math.max(low, 0);
        }
        return low == 0;
    }
}