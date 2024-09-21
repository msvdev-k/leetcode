package ru.msvdev.leetcode.topInterview150.twopointers;

/**
 * 392. Is Subsequence
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * <p>
 * Constraints:
 * -- 0 <= s.length <= 100
 * -- 0 <= t.length <= 104
 * -- s and t consist only of lowercase English letters.
 * <p>
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check
 * one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class N392IsSubsequence {

    public boolean isSubsequence1(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        if (lengthS == 0) return true;
        if (lengthS > lengthT) return false;

        int sIdx = 0;
        char sChar = s.charAt(sIdx);

        for (int tIdx = 0; tIdx < lengthT; tIdx++) {
            char tChar = t.charAt(tIdx);
            if (sChar == tChar) {
                sIdx++;
                if (sIdx == lengthS) {
                    return true;
                } else {
                    sChar = s.charAt(sIdx);
                }
            }
        }

        return false;
    }


    public boolean isSubsequence2(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        if (lengthS == 0) return true;
        if (lengthS > lengthT) return false;

        int sIdx = 0;
        int tIdx = 0;
        while (sIdx < lengthS && tIdx < lengthT) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx++;
        }

        return sIdx == lengthS;
    }

}
