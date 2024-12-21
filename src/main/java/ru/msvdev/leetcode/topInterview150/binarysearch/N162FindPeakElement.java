package ru.msvdev.leetcode.topInterview150.binarysearch;

/**
 * 162. Find Peak Element
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always
 * considered to be strictly greater than a neighbor that is outside the array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * <p>
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * <p>
 * Constraints:
 * -- 1 <= nums.length <= 1000
 * -- -2^31 <= nums[i] <= 2^31 - 1
 * -- nums[i] != nums[i + 1] for all valid i.
 */
public class N162FindPeakElement {

    public int findPeakElement1(int[] nums) {
        final int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) return nums[0] > nums[1] ? 0 : 1;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int lIdx = 0;
        int rIdx = n - 1;

        while (lIdx < rIdx) {
            final int centerIdx = (lIdx + rIdx) >>> 1;

            if (nums[centerIdx] > nums[centerIdx - 1]) {
                if (nums[centerIdx] > nums[centerIdx + 1]) {
                    return centerIdx;
                } else {
                    lIdx = centerIdx + 1;
                }

            } else {
                if (nums[centerIdx + 1] > nums[centerIdx - 1]) {
                    lIdx = centerIdx + 1;
                } else {
                    rIdx = centerIdx;
                }
            }
        }

        return lIdx;
    }

    public int findPeakElement2(int[] nums) {
        int lIdx = 0;
        int rIdx = nums.length - 1;

        while (lIdx < rIdx) {
            final int centerIdx = (lIdx + rIdx) >>> 1;

            if (nums[centerIdx] > nums[centerIdx + 1]) {
                if (centerIdx == 0 || nums[centerIdx] > nums[centerIdx - 1]) {
                    return centerIdx;
                } else {
                    rIdx = centerIdx - 1;
                }

            } else {
                lIdx = centerIdx + 1;
            }
        }

        return lIdx;
    }
}
