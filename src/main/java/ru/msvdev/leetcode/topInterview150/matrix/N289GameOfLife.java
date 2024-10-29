package ru.msvdev.leetcode.topInterview150.matrix;

/**
 * 289. Game of Life
 * <p>
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular
 * automaton devised by the British mathematician John Horton Conway in 1970."
 * The board is made up of an m x n grid of cells, where each cell has an initial state:
 * live (represented by a 1) or dead (represented by a 0). Each cell interacts with its
 * eight neighbors (horizontal, vertical, diagonal) using the following four rules
 * (taken from the above Wikipedia article):
 * -- Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * -- Any live cell with two or three live neighbors lives on to the next generation.
 * -- Any live cell with more than three live neighbors dies, as if by over-population.
 * -- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * <p>
 * The next state is created by applying the above rules simultaneously to every cell in
 * the current state, where births and deaths occur simultaneously. Given the current state of
 * the m x n grid board, return the next state.
 * <p>
 * Example 1:
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * <p>
 * Example 2:
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 * <p>
 * Constraints:
 * -- m == board.length
 * -- n == board[i].length
 * -- 1 <= m, n <= 25
 * -- board[i][j] is 0 or 1.
 * <p>
 * Follow up:
 * -- Could you solve it in-place? Remember that the board needs to be updated simultaneously:
 * You cannot update some cells first and then use their updated values to update other cells.
 * -- In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches upon the border of the array
 * (i.e., live cells reach the border). How would you address these problems?
 */
public class N289GameOfLife {

    public void gameOfLife(int[][] board) {
        final int rowCount = board.length;
        final int colCount = board[0].length;

        int[] previous = null;
        int[] current = board[0];
        int[] next = (rowCount > 1) ? board[1] : null;

        // new old
        //  0   0   = 0
        //  0   1   = 1
        //  1   0   = 2
        //  1   1   = 3
        for (int i = 1; i <= rowCount; i++) {
            for (int idx1 = 0; idx1 < colCount; idx1++) {
                final int idx0 = idx1 - 1;
                final int idx2 = idx1 + 1;
                int neighbors = 0;
                if (previous != null) {
                    if (idx0 >= 0 && previous[idx0] % 2 == 1) neighbors++;
                    if (previous[idx1] % 2 == 1) neighbors++;
                    if (idx2 < colCount && previous[idx2] % 2 == 1) neighbors++;
                }
                if (next != null) {
                    if (idx0 >= 0 && next[idx0] == 1) neighbors++;
                    if (next[idx1] == 1) neighbors++;
                    if (idx2 < colCount && next[idx2] == 1) neighbors++;
                }

                if (idx0 >= 0 && current[idx0] % 2 == 1) neighbors++;
                if (idx2 < colCount && current[idx2] == 1) neighbors++;

                if (current[idx1] == 1) {
                    if (neighbors == 2 || neighbors == 3) {
                        current[idx1] = 3;
                    }
                } else {
                    if (neighbors == 3) {
                        current[idx1] = 2;
                    }
                }
            }

            previous = current;
            current = next;
            next = (i + 1 < rowCount) ? board[i + 1] : null;
        }

        for (int[] row : board) {
            for (int i = 0; i < colCount; i++) {
                row[i] >>>= 1;
            }
        }
    }
}
