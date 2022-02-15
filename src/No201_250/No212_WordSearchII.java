package No201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No212_WordSearchII {

    char[][] mBoard;
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;

            for(Character letter : word.toCharArray()){
                if(node.children.containsKey(letter)){
                    node = node.children.get(letter);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }

            node.word = word;
        }

        this.mBoard = board;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(root.children.containsKey(board[row][col])){
                    backtracking(row, col, root);
                }
            }
        }

        return this.result;
    }

    private void backtracking(int row, int col, TrieNode parent){
        Character letter = this.mBoard[row][col];
        TrieNode currNode = parent.children.get(letter);

        if(currNode.word != null){
            this.result.add(currNode.word);
            currNode.word = null;
        }

        this.mBoard[row][col] = '#';

        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, -1, 0 ,1};

        for(int index = 0; index < 4; index++){
            int newRow = row + rowOffset[index];
            int newCol = col + colOffset[index];

            if(newRow < 0 || newRow >= this.mBoard.length || newCol < 0 || newCol >= this.mBoard[0].length){
                continue;
            }

            if(currNode.children.containsKey(this.mBoard[newRow][newCol])){
                backtracking(newRow, newCol, currNode);
            }
        }

        this.mBoard[row][col] = letter;
        if(currNode.children.isEmpty()){
            parent.children.remove(letter);
        }
    }

    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode(){}
    }
}
