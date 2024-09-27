package ru.msvdev.leetcode.topInterview150.slidingwindow;

/**
 * 209. Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length
 * of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * Constraints:
 * -- 1 <= target <= 109
 * -- 1 <= nums.length <= 105
 * -- 1 <= nums[i] <= 104
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which
 * the time complexity is O(n log(n)).
 */
public class N209MinimumSizeSubarraySum {

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int leftIdx = 0, rightIdx = 1;
        int sum = nums[0];

        while (sum < target && rightIdx < n) {
            sum += nums[rightIdx];
            rightIdx++;
        }
        while (sum >= target) {
            sum -= nums[leftIdx];
            leftIdx++;
        }
        if (leftIdx > 0) {
            leftIdx--;
            sum += nums[leftIdx];
        }

        if (sum < target) {
            return 0;
        } else if (rightIdx == n) {
            return rightIdx - leftIdx;
        }

        int minLength = rightIdx - leftIdx;

        while (rightIdx < n) {
            sum += nums[rightIdx];
            rightIdx++;

            while (sum >= target) {
                sum -= nums[leftIdx];
                leftIdx++;
            }
            leftIdx--;
            sum += nums[leftIdx];

            int length = rightIdx - leftIdx;
            if (minLength > length) {
                minLength = length;
                if (minLength == 1) {
                    break;
                }
            }
        }

        return minLength;
    }


    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int lIdx = 0, rIdx = 1;
        int minLength = Integer.MAX_VALUE;
        int sum = nums[0];

        if (sum >= target) return 1;

        while (rIdx < n) {
            do {
                sum += nums[rIdx++];
            } while (sum < target && rIdx < n);

            while ((sum -= nums[lIdx++]) >= target) ;
            if (lIdx > 0) sum += nums[--lIdx];

            if (sum >= target) {
                int length = rIdx - lIdx;
                if (minLength > length) {
                    minLength = length;
                    if (minLength == 1) {
                        break;
                    }
                }
            }
        }

        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }


    public int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length;
        int lIdx = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = nums[0];

        if (sum >= target) return 1;

        for (int rIdx = 1; rIdx < n; rIdx++) {
            sum += nums[rIdx];

            if (sum >= target) {
                while ((sum -= nums[lIdx++]) >= target) ;
                if (lIdx > 0) sum += nums[--lIdx];

                int length = rIdx - lIdx + 1;
                if (minLength > length) {
                    minLength = length;
                    if (minLength == 1) break;
                }
            }
        }

        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }

}
