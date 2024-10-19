package ru.msvdev.leetcode.topInterview150.math;

/**
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 * <p>
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * Constraints:
 * -- -100.0 < x < 100.0
 * -- -2^31 <= n <= 2^31-1
 * -- n is an integer.
 * -- Either x is not zero or n > 0.
 * -- -10^4 <= x^n <= 10^4
 */
public class N50PowXN {

    public double myPow1(double x, int n) {
        if (n == 0) return 1.0;

        final boolean positiveN = n > 0;
        long pow = Math.abs((long) n);
        double rx = 1.0;

        while (pow > 1) {
            if (pow % 2 == 1) rx *= x;
            x *= x;
            pow >>= 1;
        }

        return positiveN ? rx * x : 1.0 / (rx * x);
    }


    public double myPow2(double x, int n) {
        if (n == 0) return 1.0;

        long pow = n;
        double rx = 1.0;

        if (n < 0) {
            pow = -pow;
            x = 1 / x;
        }

        while (pow > 1) {
            if (pow % 2 == 1) rx *= x;
            x *= x;
            pow >>= 1;
        }

        return rx * x;
    }
}
