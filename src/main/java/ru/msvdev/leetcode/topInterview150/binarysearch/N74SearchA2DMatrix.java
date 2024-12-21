package ru.msvdev.leetcode.topInterview150.binarysearch;

/**
 * 74. Search a 2D Matrix
 * <p>
 * You are given an m x n integer matrix with the following two properties:
 * -- Each row is sorted in non-decreasing order.
 * -- The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 * <p>
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * <p>
 * Constraints:
 * -- m == matrix.length
 * -- n == matrix[i].length
 * -- 1 <= m, n <= 100
 * -- -1e4 <= matrix[i][j], target <= 1e4
 */
public class N74SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) return false;

        int firstRowIdx = 0;
        int lastRowIdx = matrix.length - 1;

        while (firstRowIdx < lastRowIdx) {
            final int centerRowIdx = (firstRowIdx + lastRowIdx) >>> 1;

            if (matrix[centerRowIdx][0] > target) {
                lastRowIdx = centerRowIdx - 1;
            } else {
                if (matrix[centerRowIdx + 1][0] <= target) {
                    firstRowIdx = centerRowIdx + 1;
                } else {
                    firstRowIdx = centerRowIdx;
                    break;
                }
            }
        }

        final int[] nums = matrix[firstRowIdx];

        int lIdx = 0;
        int rIdx = nums.length - 1;

        while (lIdx <= rIdx) {
            final int centerIdx = (lIdx + rIdx) >>> 1;
            final int num = nums[centerIdx];

            if (num < target) {
                lIdx = centerIdx + 1;
            } else if (num > target) {
                rIdx = centerIdx - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
