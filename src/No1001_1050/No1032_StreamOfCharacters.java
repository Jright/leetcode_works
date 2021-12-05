package No1001_1050;

import java.util.*;

public class No1032_StreamOfCharacters {
    class Node{
        boolean word = false;
        Map<Character, Node> children = new HashMap<>();
    }

    Node node = new Node();

    Deque<Character> stream = new ArrayDeque<>();

    public No1032_StreamOfCharacters(String[] words) {

        for(String word: words){
            Node newNode = node;
            String reversedWord = new StringBuilder(word).reverse().toString();
            for(char ch: reversedWord.toCharArray()){
                if(!newNode.children.containsKey(ch)){
                    newNode.children.put(ch, new Node());
                }
                newNode = newNode.children.get(ch);
            }
            newNode.word = true;
        }
    }

    public boolean query(char letter) {
        stream.addFirst(letter);
        Node newNode = node;
        for(char ch: stream){
            if(newNode.word){
                return true;
            }
            if(!newNode.children.containsKey(ch)){
                return false;
            }
            newNode = newNode.children.get(ch);
        }
        return newNode.word;
    }
}
