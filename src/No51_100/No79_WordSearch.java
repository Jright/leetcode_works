package No51_100;

public class No79_WordSearch {

    int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return false;
        }

        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(exists(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int i, int j, String word, int index){
        if(index >= word.length()){
            return true;
        }

        if (i < 0 || i == this.ROWS || j < 0 || j == this.COLS
                || board[i][j] != word.charAt(index)){
            return false;
        }


        boolean ret = false;

        board[i][j] = '#';


        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = exists(board, i + rowOffsets[d], j + colOffsets[d], word, index + 1);
            if (ret){
                break;
            }
        }

        board[i][j] = word.charAt(index);
        return ret;

    }
}
