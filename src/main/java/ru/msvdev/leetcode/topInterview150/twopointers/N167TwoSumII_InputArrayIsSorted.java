package ru.msvdev.leetcode.topInterview150.twopointers;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be
 * numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array
 * [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Constraints:
 * -- 2 <= numbers.length <= 3 * 104
 * -- -1000 <= numbers[i] <= 1000
 * -- numbers is sorted in non-decreasing order.
 * -- -1000 <= target <= 1000
 * -- The tests are generated such that there is exactly one solution.
 */
public class N167TwoSumII_InputArrayIsSorted {

    public int[] twoSum1(int[] numbers, int target) {
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;

        int sum = numbers[leftIdx] + numbers[rightIdx];

        while (sum != target) {
            if (sum < target) {
                leftIdx++;
            } else {
                rightIdx--;
            }
            sum = numbers[leftIdx] + numbers[rightIdx];
        }

        return new int[]{leftIdx + 1, rightIdx + 1};
    }


    public int[] twoSum2(int[] numbers, int target) {
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;

        int leftNumber = numbers[leftIdx];
        int rightNumber = numbers[rightIdx];
        int sum = leftNumber + rightNumber;

        while (sum != target) {
            if (sum < target) {
                leftIdx++;
                leftNumber = numbers[leftIdx];
            } else {
                rightIdx--;
                rightNumber = numbers[rightIdx];
            }
            sum = leftNumber + rightNumber;
        }

        return new int[]{leftIdx + 1, rightIdx + 1};
    }
}
