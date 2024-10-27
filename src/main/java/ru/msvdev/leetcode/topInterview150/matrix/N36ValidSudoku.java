package ru.msvdev.leetcode.topInterview150.matrix;

/**
 * 36. Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
 * according to the following rules:
 * -- Each row must contain the digits 1-9 without repetition.
 * -- Each column must contain the digits 1-9 without repetition.
 * -- Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * -- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * -- Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * <p>
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * Constraints:
 * -- board.length == 9
 * -- board[i].length == 9
 * -- board[i][j] is a digit 1-9 or '.'.
 */
public class N36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // Cash
        final int[] rows = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        final int[] cols = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        final int[] squares = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 9; i++) {
            final char[] row = board[i];
            int squareShift = (i / 3) * 3;

            for (int j = 0; j < 9; j++) {
                final int numIdx = row[j] - '1';
                if (numIdx >= 0) {
                    final int mask = 1 << numIdx;
                    final int squareIdx = squareShift + (j / 3);
                    final int cashFlag = (rows[i] | cols[j] | squares[squareIdx]) & mask;

                    if (cashFlag != 0) return false;

                    rows[i] |= mask;
                    cols[j] |= mask;
                    squares[squareIdx] |= mask;
                }
            }
        }

        return true;
    }

}
