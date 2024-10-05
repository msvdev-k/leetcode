package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.Arrays;

/**
 * 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * Constraints:
 * -- 0 <= nums.length <= 10^5
 * -- -10^9 <= nums[i] <= 10^9
 */
public class N128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        Arrays.sort(nums);

        int maxSequenceLength = 0;
        int sequenceLength = 1;
        for (int i = 1; i < n; i++) {
            int delta = nums[i] - nums[i - 1];
            if (delta > 1) {
                if (maxSequenceLength < sequenceLength) {
                    maxSequenceLength = sequenceLength;
                }
                sequenceLength = 1;
            } else if (delta == 1) {
                sequenceLength++;
            }
        }

        return Math.max(maxSequenceLength, sequenceLength);
    }
}
