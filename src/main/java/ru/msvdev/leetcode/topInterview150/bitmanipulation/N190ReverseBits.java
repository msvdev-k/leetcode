package ru.msvdev.leetcode.topInterview150.bitmanipulation;

/**
 * 190. Reverse Bits
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * -- Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as a signed integer type.
 * They should not affect your implementation, as the integer's internal binary
 * representation is the same, whether it is signed or unsigned.
 * -- In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 2 above, the input represents the signed integer -3 and
 * the output represents the signed integer -1073741825.
 * <p>
 * Example 1:
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents
 * the unsigned integer 43261596, so return 964176192 which its binary
 * representation is 00111001011110000010100101000000.
 * <p>
 * Example 2:
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents
 * the unsigned integer 4294967293, so return 3221225471 which its binary
 * representation is 10111111111111111111111111111111.
 * <p>
 * Constraints:
 * -- The input must be a binary string of length 32
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class N190ReverseBits {

    public int reverseBits1(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }

    public int reverseBits2(int n) {
        n = (n >>> 16) | (n << 16);
        n = (n >>> 8) & 0x00FF00FF | (n << 8) & 0xFF00FF00;
        n = (n >>> 4) & 0x0F0F0F0F | (n << 4) & 0xF0F0F0F0;
        n = (n >>> 2) & 0x33333333 | (n << 2) & 0xCCCCCCCC;
        n = (n >>> 1) & 0x55555555 | (n << 1) & 0xAAAAAAAA;

        return n;
    }
}
