package ru.msvdev.leetcode.topInterview150.math;

/**
 * 172. Factorial Trailing Zeroes
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * <p>
 * Example 3:
 * Input: n = 0
 * Output: 0
 * <p>
 * Constraints:
 * -- 0 <= n <= 1e4
 * <p>
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class N172FactorialTrailingZeroes {

    public int trailingZeroes1(int n) {
        if (n < 5) return 0;

        int numberOfTrailingZeroes = 0;
        int mulFive = 1;
        int countMultiFive;
        do {
            mulFive *= 5;
            countMultiFive = n / mulFive;
            numberOfTrailingZeroes += countMultiFive;
        } while (countMultiFive > 0);

        return numberOfTrailingZeroes;
    }


    public int trailingZeroes2(int n) {
        return n / 3125 + n / 625 + n / 125 + n / 25 + n / 5;
    }


    public int trailingZeroes3(int n) {
        int numberOfTrailingZeroes = 0;

        while (n >= 5) {
            n /= 5;
            numberOfTrailingZeroes += n;
        }

        return numberOfTrailingZeroes;
    }
}
