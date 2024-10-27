package ru.msvdev.leetcode.topInterview150.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. Spiral Matrix
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Constraints:
 * -- m == matrix.length
 * -- n == matrix[i].length
 * -- 1 <= m, n <= 10
 * -- -100 <= matrix[i][j] <= 100
 */
public class N54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        if (m == 1) return Arrays.stream(matrix[0]).boxed().toList();

        final List<Integer> outArray = new ArrayList<>(m * n);

        int rowIdx = 0, colIdx = 0;
        int step = 1;
        int singPeriods = 1;
        int rowStop = m - singPeriods;
        int colStop = n - singPeriods;

        for (int iteration = 0; iteration < m * n; iteration++) {
            outArray.add(matrix[rowIdx][colIdx]);

            if (colIdx != colStop) {
                colIdx += step;

            } else if (rowIdx != rowStop) {
                rowIdx += step;

            } else {
                if (step > 0) {
                    rowStop = singPeriods;
                    colStop = singPeriods - 1;
                    step = -1;
                } else {
                    singPeriods++;
                    rowStop = m - singPeriods;
                    colStop = n - singPeriods;
                    step = 1;
                }
                colIdx += step;
            }
        }

        return outArray;
    }


}
