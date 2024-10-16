package ru.msvdev.leetcode.topInterview150.math;

/**
 * 9. Palindrome Number
 * <p>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class N9PalindromeNumber {

    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        final int[] digits = new int[10];
        int idx = -1;
        do {
            idx++;
            digits[idx] = x % 10;
            x /= 10;
        } while (x != 0);

        for (int i = 0; i <= idx; i++) {
            if (digits[i] != digits[idx - i]) return false;
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;

        int rx = 0;
        int fx = x;
        do {
            rx *= 10;
            rx += fx % 10;
            fx /= 10;
        } while (fx != 0);

        return rx == x;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;

        int rx = 0;
        int fx = x;
        do {
            rx = rx * 10 + fx % 10;
            fx /= 10;
        } while (fx > rx);

        return fx == rx || fx == (rx / 10);
    }
}
