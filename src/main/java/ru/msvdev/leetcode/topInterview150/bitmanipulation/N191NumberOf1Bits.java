package ru.msvdev.leetcode.topInterview150.bitmanipulation;

/**
 * 191. Number of 1 Bits
 * <p>
 * Given a positive integer n, write a function that returns the number of set bits in its
 * binary representation (also known as the Hamming weight).
 * <p>
 * Example 1:
 * Input: n = 11
 * Output: 3
 * Explanation:
 * The input binary string 1011 has a total of three set bits.
 * <p>
 * Example 2:
 * Input: n = 128
 * Output: 1
 * Explanation:
 * The input binary string 10000000 has a total of one set bit.
 * <p>
 * Example 3:
 * Input: n = 2147483645
 * Output: 30
 * Explanation:
 * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 * <p>
 * Constraints:
 * -- 1 <= n <= 2^31 - 1
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class N191NumberOf1Bits {

    public int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >> 16) & 0x0000FFFF);

        return n;
    }
}
