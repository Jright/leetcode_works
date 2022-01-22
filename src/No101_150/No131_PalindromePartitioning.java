package No101_150;

import java.util.ArrayList;
import java.util.List;

public class No131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        dfs(result, new ArrayList<>(), s, 0, dp);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> currList, String s, int start,
                                   boolean[][] dp){
        if(start >= s.length()){
            result.add(new ArrayList<>(currList));
        }

        for(int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1] == true)) {
                currList.add(s.substring(start, end + 1));
                dp[start][end] = true;
                dfs(result, currList, s, end + 1, dp);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
