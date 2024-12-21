package ru.msvdev.leetcode.topInterview150.binarysearch;

/**
 * 33. Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
 * index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ...,
 * nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7]
 * might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target
 * if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * Constraints:
 * -- 1 <= nums.length <= 5000
 * -- -1e4 <= nums[i] <= 1e4
 * -- All values of nums are unique.
 * -- nums is an ascending array that is possibly rotated.
 * -- -1e4 <= target <= 1e4
 */
public class N33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lIdx = 0;
        int rIdx = nums.length - 1;

        while (lIdx <= rIdx) {
            final int centerIdx = (lIdx + rIdx) >>> 1;

            if (nums[lIdx] <= nums[centerIdx]) {
                if (nums[lIdx] <= target && target < nums[centerIdx]) {
                    rIdx = centerIdx - 1;
                } else {
                    lIdx = centerIdx + 1;
                }

            } else {
                if (nums[centerIdx] < target && target <= nums[rIdx]) {
                    lIdx = centerIdx + 1;
                } else {
                    rIdx = centerIdx - 1;
                }
            }

            if (nums[centerIdx] == target) {
                return centerIdx;
            }
        }

        return -1;
    }
}
