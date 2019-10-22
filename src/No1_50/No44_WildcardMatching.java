package No1_50;

public class No44_WildcardMatching {

    public boolean isMatch(String s, String p) {

        // TODO Copied answer from:
//        https://www.programcreek.com/2014/06/leetcode-wildcard-matching-java/
        int sPointer = 0;
        int pPointer = 0;
        int starIndex = -1;
        int savedIIndex = -1;

        while (sPointer < s.length()) {

            if (pPointer < p.length() && (p.charAt(pPointer) == '?' || p.charAt(pPointer) == s.charAt(sPointer))) {
                sPointer++;
                pPointer++;
            } else if (pPointer < p.length() && p.charAt(pPointer) == '*') {
                starIndex = pPointer;
                savedIIndex = sPointer;
                pPointer++;
            } else if (starIndex != -1) {
                pPointer = starIndex + 1;
                sPointer = savedIIndex + 1;
                savedIIndex++;
            } else {
                return false;
            }
        }

        while (pPointer < p.length() && p.charAt(pPointer) == '*') {
            pPointer++;
        }

        return pPointer == p.length();
    }
}
