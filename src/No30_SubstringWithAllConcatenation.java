import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s)
 * in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * TODO Java TLE But Original C++ does not
 */
public class No30_SubstringWithAllConcatenation {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> subPositions = new ArrayList<>();
        if(words.length == 0 || s.length() == 0){
            return subPositions;
        }

        int dictWordLength = words[0].length();
        int dictSize = 0;
        HashMap<String, Integer> dictMap = new HashMap<>();


        for(String word : words){
            if(dictMap.containsKey(word)){
                dictMap.put(word, dictMap.get(word) + 1);
            }else{
                dictMap.put(word, 1);
            }
            dictSize++;
        }

        for(int i = 0; i < s.length(); i++){

            HashMap<String, Integer> stringMap = new HashMap<>();

            int wordCount = 0;
            int start = i;
            for(int j = i; (j + dictWordLength) <= s.length(); j += dictWordLength){
                String subString = s.substring(j, j + dictWordLength);
                if(dictMap.containsKey(subString)){
                    if(stringMap.containsKey(subString)){
                        stringMap.put(subString, stringMap.get(subString) + 1);
                    }else{
                        stringMap.put(subString, 1);
                    }
                    wordCount++;
                }else{
                    stringMap.clear();
                    wordCount = 0;
                    start = j + dictWordLength;
                    continue;
                }

                while(stringMap.get(subString) > dictMap.get(subString)){
                    stringMap.put(s.substring(start, start + dictWordLength), stringMap.get(s.substring(start, start + dictWordLength)) - 1);
                    start += dictWordLength;
                    wordCount--;
                }

                if(wordCount == dictSize && !subPositions.contains(start)){
                    subPositions.add(start);
                }
            }
        }
        return subPositions;
    }

    public static void main(String[] args) {
        List<Integer> nums = findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        for(int num : nums){
            System.out.println(num);
        }
    }
}
