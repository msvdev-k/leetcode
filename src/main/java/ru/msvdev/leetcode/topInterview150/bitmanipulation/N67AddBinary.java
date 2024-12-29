package ru.msvdev.leetcode.topInterview150.bitmanipulation;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * Constraints:
 * -- 1 <= a.length, b.length <= 1e4
 * -- a and b consist only of '0' or '1' characters.
 * -- Each string does not contain leading zeros except for the zero itself.
 */
public class N67AddBinary {

    private static final char ZERO_CH = '0';
    private static final char ONE_CH = '1';

    public String addBinary1(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        final int lenA = a.length();
        final int lenB = b.length();
        final char[] sum = new char[lenA + 1];

        int aIdx = lenA - 1;
        int sumIdx = lenA;
        int register = 0;

        for (int bIdx = lenB - 1; bIdx >= 0; bIdx--) {
            if (b.charAt(bIdx) == ONE_CH) register++;
            if (a.charAt(aIdx) == ONE_CH) register++;

            if (register < 2) {
                sum[sumIdx] = (register == 0) ? ZERO_CH : ONE_CH;
                register = 0;
            } else {
                sum[sumIdx] = (register == 2) ? ZERO_CH : ONE_CH;
                register = 1;
            }

            aIdx--;
            sumIdx--;
        }

        for (; aIdx >= 0; aIdx--) {
            if (a.charAt(aIdx) == ONE_CH) register++;

            if (register < 2) {
                sum[sumIdx] = (register == 0) ? ZERO_CH : ONE_CH;
                register = 0;
            } else {
                sum[sumIdx] = ZERO_CH;
                register = 1;
            }

            sumIdx--;
        }

        if (register == 0) {
            return new String(sum, 1, sum.length - 1);
        }

        sum[0] = ONE_CH;
        return new String(sum);
    }


    private static final byte ZERO = 48;
    private static final byte ONE = 49;

    public String addBinary2(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        final byte[] bArray = b.getBytes();
        final byte[] sum = new byte[a.length() + 1];
        sum[0] = ZERO;
        System.arraycopy(a.getBytes(), 0, sum, 1, a.length());

        int sumIdx = sum.length - 1;
        byte register = ZERO;

        for (int bIdx = bArray.length - 1; bIdx >= 0; bIdx--) {
            sum[sumIdx] += (byte) (bArray[bIdx] - register);
            if (sum[sumIdx] <= ONE) {
                register = ZERO;
            } else {
                sum[sumIdx] -= 2;
                register = ZERO - 1;
            }

            sumIdx--;
        }

        for (; sumIdx >= 0; sumIdx--) {
            sum[sumIdx] += (byte) (ZERO - register);
            if (sum[sumIdx] <= ONE) break;

            sum[sumIdx] -= 2;
            register = ZERO - 1;
        }

        if (sum[0] == ONE) {
            return new String(sum);
        }

        return new String(sum, 1, sum.length - 1);
    }
}
