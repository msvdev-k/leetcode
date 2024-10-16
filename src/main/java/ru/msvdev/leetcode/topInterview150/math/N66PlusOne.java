package ru.msvdev.leetcode.topInterview150.math;

/**
 * 66. Plus One
 * <p>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit
 * of the integer. The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * Constraints:
 * -- 1 <= digits.length <= 100
 * -- 0 <= digits[i] <= 9
 * -- digits does not contain any leading 0's.
 */
public class N66PlusOne {

    public int[] plusOne(int[] digits) {
        final int n = digits.length - 1;

        digits[n]++;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i + 1] > 9) {
                digits[i] += digits[i + 1] / 10;
                digits[i + 1] %= 10;
            } else {
                return digits;
            }
        }

        if (digits[0] > 9) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = newDigits[1] / 10;
            newDigits[1] %= 10;
            return newDigits;
        }

        return digits;
    }
}
