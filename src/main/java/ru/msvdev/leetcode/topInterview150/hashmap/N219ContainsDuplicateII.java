package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.HashMap;

/**
 * 219. Contains Duplicate II
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct
 * indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p>
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * <p>
 * Constraints:
 * -- 1 <= nums.length <= 10^5
 * -- -10^9 <= nums[i] <= 10^9
 * -- 0 <= k <= 10^5
 */
public class N219ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        HashMap<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (indexes.containsKey(num)) {
                int index = indexes.get(num);
                if (i - index <= k) return true;
            }
            indexes.put(num, i);
        }

        return false;
    }
}
