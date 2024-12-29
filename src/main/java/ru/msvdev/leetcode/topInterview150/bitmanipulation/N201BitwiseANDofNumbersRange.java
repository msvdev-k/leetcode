package ru.msvdev.leetcode.topInterview150.bitmanipulation;

/**
 * 201. Bitwise AND of Numbers Range
 * <p>
 * Given two integers left and right that represent the range [left, right],
 * return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * Input: left = 5, right = 7
 * Output: 4
 * <p>
 * Example 2:
 * Input: left = 0, right = 0
 * Output: 0
 * <p>
 * Example 3:
 * Input: left = 1, right = 2147483647
 * Output: 0
 * <p>
 * Constraints:
 * -- 0 <= left <= right <= 2^31 - 1
 */
public class N201BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd1(int left, int right) {
        if (left == right) return left;

        int mask = 0xC0000000; //1100 0000 0000 ...
        while ((left & mask) == (right & mask)) mask >>= 1;

        return left & (mask << 1);
    }


    public int rangeBitwiseAnd2(int left, int right) {
        if (left == right) return left;

        int minShift = 0;
        int maxShift = 30;

        while (minShift < maxShift) {
            final int shift = (minShift + maxShift) >>> 1;

            if ((left >> shift) == (right >> shift)) {
                maxShift = shift - 1;
            } else {
                minShift = shift + 1;
            }
        }

        return left & (0xFFFFFFFF << minShift);
    }
}
