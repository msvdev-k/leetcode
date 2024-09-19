package ru.msvdev.leetcode.topInterview150.array;

import java.util.Arrays;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * <p>
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that
 * you can reach nums[n - 1].
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * Constraints:
 * -- 1 <= nums.length <= 104
 * -- 0 <= nums[i] <= 1000
 * -- It's guaranteed that you can reach nums[n - 1].
 */
public class N45JumpGameII {

    public int jump1(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int[] jumps = new int[n];

        int indexOfPreviousJump = nums[0] + 1;
        if (indexOfPreviousJump >= n) return 1;

        Arrays.fill(jumps, 0, indexOfPreviousJump, 1);

        for (int i = 1; i < n; i++) {
            int countJumps = jumps[i] + 1;
            int indexOfNextJump = i + nums[i] + 1;

            if (indexOfNextJump >= n) return countJumps;

            if (indexOfNextJump > indexOfPreviousJump) {
                Arrays.fill(jumps, indexOfPreviousJump, indexOfNextJump, countJumps);
                indexOfPreviousJump = indexOfNextJump;
            }
        }

        return jumps[n - 1];
    }


    public int jump2(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int countJumps = 1;

        int startIdx = 0;
        int stopIdx = nums[0] + 1;

        while (stopIdx < n) {
            int newStopIdx = stopIdx;
            for (int i = startIdx; i < stopIdx; i++) {
                int tmp = i + nums[i] + 1;
                if (tmp > newStopIdx) {
                    newStopIdx = tmp;
                }
            }

            startIdx = stopIdx;
            stopIdx = newStopIdx;
            countJumps++;
        }

        return countJumps;
    }
}
