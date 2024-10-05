package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * <p>
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * Example 2:
 * Input: n = 2
 * Output: false
 * <p>
 * Constraints:
 * -- 1 <= n <= 2^31 - 1
 */
public class N202HappyNumber {

    public boolean isHappy(int n) {
        final Set<Integer> integerSet = new HashSet<>();

        while (n > 1) {
            int sum = 0;
            while (n > 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            n = sum;

            if (integerSet.contains(n)) return false;
            integerSet.add(n);
        }

        return n == 1;
    }
}
