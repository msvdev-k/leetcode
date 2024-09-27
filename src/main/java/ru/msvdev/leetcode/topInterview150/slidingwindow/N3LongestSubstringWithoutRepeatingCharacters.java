package ru.msvdev.leetcode.topInterview150.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * A substring is a contiguous non-empty sequence of characters within a string.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * -- 0 <= s.length <= 5 * 104
 * -- s consists of English letters, digits, symbols and spaces.
 */
public class N3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int lIdx = 0;
        int maxLength = 0;
        Set<Character> characterSet = new HashSet<>();
        characterSet.add(s.charAt(0));

        for (int rIdx = 1; rIdx < n; rIdx++) {
            char rCh = s.charAt(rIdx);
            if (characterSet.contains(rCh)) {
                int length = rIdx - lIdx;
                if (maxLength < length) maxLength = length;

                while (lIdx <= rIdx) {
                    char lCh = s.charAt(lIdx);
                    lIdx++;
                    if (lCh != rCh) {
                        characterSet.remove(lCh);
                    } else {
                        break;
                    }
                }

            } else {
                characterSet.add(rCh);
            }
        }

        return Math.max(maxLength, characterSet.size());
    }
}
