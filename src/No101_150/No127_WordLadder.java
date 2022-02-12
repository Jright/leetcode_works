package No101_150;

import Data_Structures.Pair;

import java.util.*;

public class No127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();

        Map<String, List<String>> allComboMap = new HashMap<>();

        for(String word : wordList){
            for(int index = 0; index < L; index++){
                String newWord = word.substring(0, index) + '*' + word.substring(index + 1, L);
                List<String> transformations = allComboMap.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboMap.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!queue.isEmpty()){
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int index = 0; index < L; index++){
                String newWord = word.substring(0, index) + '*' + word.substring(index + 1, L);

                for(String adjWord : allComboMap.getOrDefault(newWord, new ArrayList<>())){
                    if(adjWord.equals(endWord)){
                        return level + 1;
                    }

                    if(!visited.containsKey(adjWord)){
                        visited.put(adjWord, true);
                        queue.add(new Pair(adjWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
