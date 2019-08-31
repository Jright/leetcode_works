package No1_50;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

//TODO Complexity: Catalan Number
public class No22_GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> answer = new ArrayList<>();
        backtrack(answer, "", 0 ,0 ,n);
        return answer;
    }


    public void backtrack(List<String> answer, String currentString, int left, int right, int max){
        if(currentString.length() == max * 2){
            answer.add(currentString);
            return;
        }

        if(left < max){
            backtrack(answer, currentString + "(" , left + 1, right, max);
        }

        if(right < left){
            backtrack(answer, currentString + ")", left, right + 1, max);
        }


    }
}
