package ru.msvdev.leetcode.topInterview150.matrix;

/**
 * 48. Rotate Image
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Constraints:
 * -- n == matrix.length == matrix[i].length
 * -- 1 <= n <= 20
 * -- -1000 <= matrix[i][j] <= 1000
 */
public class N48RotateImage {

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        if (n == 1) return;

        for (int i = 0; i < n / 2; i++) {
            final int lastIdx = n - i - 1;
            for (int j = i; j < lastIdx; j++) {
                int tmp1 = matrix[j][lastIdx];
                matrix[j][lastIdx] = matrix[i][j];

                int tmp2 = matrix[lastIdx][lastIdx - j + i];
                matrix[lastIdx][lastIdx - j + i] = tmp1;

                tmp1 = matrix[lastIdx - j + i][i];
                matrix[lastIdx - j + i][i] = tmp2;

                matrix[i][j] = tmp1;
            }
        }
    }
}
