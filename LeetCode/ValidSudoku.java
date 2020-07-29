import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {//
              //  0   1   2   3   4   5   6   7   8
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(s.isValidSudoku2(board));
    }
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int [] rows = new int [9];
            int [] cols = new int [9];
            int[] squares = new int[9];

            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[0].length; col++){
                    if (board[row][col] == '.') continue;
                    int val = 1 <<  (board[row][col] - '1');
                    int k = 3*(row/3)+(col/3);
                    if((val & rows[row]) > 0 ) return false;
                    if((val & cols[col]) > 0 ) return false;
                    if((val & squares[k]) > 0 ) return false;

                    rows[row] |= val;
                    cols[col] |= val;
                    squares[k] |= val;
                    }

                }
            return true;
            }


        public boolean isValidSudoku2(char[][] board) {
            Set seen = new HashSet();
            for (int i=0; i<9; ++i) {
                for (int j=0; j<9; ++j) {
                    if (board[i][j] != '.') {
                        String b = "(" + board[i][j] + ")";
                        if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                            return false;
                    }
                }
            }
            return true;
        }

    }


}
