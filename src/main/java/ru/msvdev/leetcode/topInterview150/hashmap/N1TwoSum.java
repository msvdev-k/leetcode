package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.HashMap;

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use
 * the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * -- 2 <= nums.length <= 10^4
 * -- -109 <= nums[i] <= 109
 * -- -109 <= target <= 109
 * -- Only one valid answer exists.
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class N1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final int n = nums.length;
        if (n == 2) {
            return (nums[0] + nums[1] == target) ? new int[]{0, 1} : new int[0];
        }

        HashMap<Integer, Integer> pairIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (pairIndexMap.containsKey(num)) {
                return new int[]{pairIndexMap.get(num), i};
            } else {
                pairIndexMap.put(target - num, i);
            }
        }

        return new int[0];
    }
}
