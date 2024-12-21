package ru.msvdev.leetcode.topInterview150.binarysearch;

/**
 * 35. Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * Constraints:
 * -- 1 <= nums.length <= 1e4
 * -- -1e4 <= nums[i] <= 1e4
 * -- nums contains distinct values sorted in ascending order.
 * -- -1e4 <= target <= 1e4
 */
public class N35SearchInsertPosition {

    public int searchInsert1(int[] nums, int target) {
        final int n = nums.length;
        if (target <= nums[0]) return 0;
        if (target > nums[n - 1]) return n;

        int lIdx = 0;
        int rIdx = n - 1;

        while (lIdx <= rIdx) {
            int centerIdx = (lIdx + rIdx) >>> 1;
            int num = nums[centerIdx];

            if (num < target) {
                lIdx = centerIdx + 1;
            } else if (num > target) {
                rIdx = centerIdx - 1;
            } else {
                return centerIdx;
            }
        }

        return lIdx;
    }

    public int searchInsert2(int[] nums, int target) {
        int lIdx = 0;
        int rIdx = nums.length - 1;

        while (lIdx <= rIdx) {
            int centerIdx = (lIdx + rIdx) >>> 1;
            int num = nums[centerIdx];

            if (num < target) {
                lIdx = centerIdx + 1;
            } else if (num > target) {
                rIdx = centerIdx - 1;
            } else {
                return centerIdx;
            }
        }

        return lIdx;
    }
}
