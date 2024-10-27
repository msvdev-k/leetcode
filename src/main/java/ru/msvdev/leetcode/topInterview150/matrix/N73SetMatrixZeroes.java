package ru.msvdev.leetcode.topInterview150.matrix;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * <p>
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * Constraints:
 * -- m == matrix.length
 * -- n == matrix[0].length
 * -- 1 <= m, n <= 200
 * -- -2^31 <= matrix[i][j] <= 2^31 - 1
 * <p>
 * Follow up:
 * -- A straightforward solution using O(mn) space is probably a bad idea.
 * -- A simple improvement uses O(m + n) space, but still not the best solution.
 * -- Could you devise a constant space solution?
 */
public class N73SetMatrixZeroes {

    public void setZeroes1(int[][] matrix) {
        final int rowCount = matrix.length;
        final int colCount = matrix[0].length;

        boolean firstRowZero = false;
        for (int col : matrix[0]) {
            if (col == 0) {
                firstRowZero = true;
                break;
            }
        }

        boolean firstColZero = false;
        for (int[] row : matrix) {
            if (row[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Cols
        for (int i = 1; i < colCount; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowCount; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // Rows
        for (int[] row : matrix) {
            if (row[0] == 0) {
                Arrays.fill(row, 0);
            }
        }

        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }

        if (firstColZero) {
            for (int[] row : matrix) {
                row[0] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        final int rowCount = matrix.length;
        final int colCount = matrix[0].length;

        boolean firstColZero = false;
        for (int[] row : matrix) {
            if (row[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        final int[] firstRow = matrix[0];
        for (int col : firstRow) {
            if (col == 0) {
                firstRow[0] = 0;
                break;
            }
        }

        for (int i = 1; i < rowCount; i++) {
            final int[] row = matrix[i];

            for (int j = 1; j < colCount; j++) {
                if (row[j] == 0) {
                    firstRow[j] = 0;
                    row[0] = 0;
                }
            }

            if (row[0] == 0) Arrays.fill(row, 0);
        }

        // Cols
        for (int i = 1; i < colCount; i++) {
            if (firstRow[i] == 0) {
                for (int j = 1; j < rowCount; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstRow[0] == 0) Arrays.fill(firstRow, 0);

        if (firstColZero) {
            for (int[] row : matrix) {
                row[0] = 0;
            }
        }
    }
}
