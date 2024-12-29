package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II
 * <p>
 * Given an integer array nums where every element appears three times except for one,
 * which appears exactly once. Find the single element and return it.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * <p>
 * Constraints:
 * -- 1 <= nums.length <= 3e4
 * -- -2^31 <= nums[i] <= 2^31 - 1
 * -- Each element in nums appears exactly three times except for one element which appears once.
 */
public class N137SingleNumberII {

    public int singleNumber1(int[] nums) {
        Map<Integer, Counter> map = new HashMap<>(nums.length / 3 + 1);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.get(num).counter++;
            } else {
                map.put(num, new Counter(1));
            }
        }

        for (Map.Entry<Integer, Counter> entry : map.entrySet()) {
            if (entry.getValue().counter == 1) return entry.getKey();
        }

        return 0;
    }

    private static class Counter {
        public int counter;

        public Counter(int counter) {
            this.counter = counter;
        }
    }

    public int singleNumber2(int[] nums) {
        int oneBit = 0;
        int twoBit = 0;

        for (int num : nums) {
            oneBit = (oneBit ^ num) & ~twoBit;
            twoBit = (twoBit ^ num) & ~oneBit;
        }

        return oneBit;
    }
}
