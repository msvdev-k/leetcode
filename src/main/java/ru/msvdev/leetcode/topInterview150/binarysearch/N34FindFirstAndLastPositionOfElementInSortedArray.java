package ru.msvdev.leetcode.topInterview150.binarysearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of
 * a given target value.
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * Constraints:
 * -- 0 <= nums.length <= 1e5
 * -- -1e9 <= nums[i] <= 1e9
 * -- nums is a non-decreasing array.
 * -- -1e9 <= target <= 1e9
 */
public class N34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        final int[] out = new int[]{-1, -1};

        int n = nums.length;
        if (n == 0) return out;

        int lIdx = 0;
        int rIdx = n - 1;

        while (lIdx < rIdx) {
            final int centerIdx = (lIdx + rIdx) >>> 1;
            final int num = nums[centerIdx];

            if (num < target) {
                lIdx = centerIdx + 1;
            } else if (num > target) {
                rIdx = centerIdx - 1;
                n = centerIdx;
            } else {
                rIdx = centerIdx;
            }
        }

        if (nums[lIdx] != target) return out;

        out[0] = lIdx;
        rIdx = n - 1;

        while (lIdx < rIdx) {
            final int centerIdx = 1 + (lIdx + rIdx) >>> 1;

            if (nums[centerIdx] > target) {
                rIdx = centerIdx - 1;
            } else {
                lIdx = centerIdx;
            }
        }

        out[1] = rIdx;

        return out;
    }
}
