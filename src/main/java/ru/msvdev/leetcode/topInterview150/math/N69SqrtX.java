package ru.msvdev.leetcode.topInterview150.math;

/**
 * 69. Sqrt(x)
 * <p>
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * <p>
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * <p>
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer,
 * 2 is returned.
 * <p>
 * Constraints:
 * -- 0 <= x <= 2^31 - 1
 */
public class N69SqrtX {

    /**
     * Метода Ньютона для поиска решения уравнения x^2 − n = 0
     */
    public int mySqrt1(int x) {
        if (x < 2) return x;

        int previous = Integer.MAX_VALUE >> 15;
        int next = (previous + x / previous) >> 1;

        while (next != previous && next != previous + 1) {
            previous = next;
            next = (previous + x / previous) >> 1;
        }

        return previous;
    }

    /**
     * Бинарный поиск по условию x / sqrt = sqrt
     */
    public int mySqrt2(int x) {
        if (x < 2) return x;

        int r = 2;
        int l = x >> 1;

        while (r < l - 1) {
            final int med = (r + l) >> 1;
            final int sqrt = x / med;
            if (sqrt > med) {
                r = med;
            } else if (sqrt < med) {
                l = med;
            } else {
                return med;
            }
        }

        return (r + l) >> 1;
    }


}
