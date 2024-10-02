package ru.msvdev.leetcode.topInterview150.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * Constraints:
 * -- m == s.length
 * -- n == t.length
 * -- 1 <= m, n <= 10^5
 * -- s and t consist of uppercase and lowercase English letters.
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class N76MinimumWindowSubstring {

    private static final int COUNT_IDX = 0;
    private static final int FOUND_IDX = 1;

    public String minWindow1(String s, String t) {
        final int sLength = s.length();
        final int tLength = t.length();
        if (tLength > sLength) return "";

        final Map<Character, int[]> charMap = new HashMap<>();
        for (int i = 0; i < tLength; i++) {
            Character ch = t.charAt(i);
            if (charMap.containsKey(ch)) {
                charMap.get(ch)[COUNT_IDX]++;
            } else {
                charMap.put(ch, new int[]{1, 0});
            }
        }

        int lIdxForMinSubstring = 0;
        int rIdxForMinSubstring = 0;
        int minSubstringLength = Integer.MAX_VALUE;
        int foundCharacter = 0;

        for (int lIdx = 0, rIdx = 0; rIdx < sLength; rIdx++) {
            Character rCh = s.charAt(rIdx);
            if (charMap.containsKey(rCh)) {
                int[] counter = charMap.get(rCh);
                counter[FOUND_IDX]++;
                if (counter[FOUND_IDX] <= counter[COUNT_IDX]) {
                    foundCharacter++;
                }
            }

            while (foundCharacter >= tLength && lIdx < rIdx) {
                Character lCh = s.charAt(lIdx);
                if (charMap.containsKey(lCh)) {
                    int[] counter = charMap.get(lCh);
                    counter[FOUND_IDX]--;
                    if (counter[FOUND_IDX] < counter[COUNT_IDX]) {
                        foundCharacter--;
                    }
                }
                lIdx++;
            }

            if (foundCharacter < tLength && lIdx > 0) {
                lIdx--;
                Character lCh = s.charAt(lIdx);
                charMap.get(lCh)[FOUND_IDX]++;
                foundCharacter++;
            }

            if (foundCharacter >= tLength) {
                int substringLength = rIdx - lIdx + 1;
                if (minSubstringLength > substringLength) {
                    minSubstringLength = substringLength;
                    lIdxForMinSubstring = lIdx;
                    rIdxForMinSubstring = rIdx + 1;
                }
            }
        }

        return (minSubstringLength != Integer.MAX_VALUE) ? s.substring(lIdxForMinSubstring, rIdxForMinSubstring) : "";
    }


    private static final int CHAR_OFFSET = 'A';

    public String minWindow2(String s, String t) {
        final int sLength = s.length();
        final int tLength = t.length();
        if (tLength > sLength) return "";

        final int[] charMap = new int[128];
        Arrays.fill(charMap, 0);
        for (int i = 0; i < tLength; i++) {
            int chIdx = ((int) t.charAt(i) - CHAR_OFFSET) << 1;
            charMap[chIdx]++;
        }

        int lIdxForMinSubstring = 0;
        int rIdxForMinSubstring = 0;
        int minSubstringLength = Integer.MAX_VALUE;
        int foundCharacter = 0;

        int lIdx = 0, rIdx = 0;
        int chCount;

        while (rIdx < sLength) {
            do {
                int rChIdx = ((int) s.charAt(rIdx) - CHAR_OFFSET) << 1;
                chCount = charMap[rChIdx];
                if (chCount > 0) {
                    charMap[rChIdx + 1]++;
                    if (charMap[rChIdx + 1] <= chCount) {
                        foundCharacter++;
                    }
                }
                rIdx++;
            } while (foundCharacter <= tLength && chCount == 0 && rIdx < sLength);

            while (foundCharacter >= tLength && lIdx < rIdx) {
                int lChIdx = ((int) s.charAt(lIdx) - CHAR_OFFSET) << 1;
                chCount = charMap[lChIdx];
                if (chCount > 0) {
                    charMap[lChIdx + 1]--;
                    if (charMap[lChIdx + 1] < chCount) {
                        foundCharacter--;
                    }
                }
                lIdx++;
            }

            if (foundCharacter < tLength && lIdx > 0) {
                lIdx--;
                int lChIdx = ((int) s.charAt(lIdx) - CHAR_OFFSET) << 1;
                charMap[lChIdx + 1]++;
                foundCharacter++;
            }

            if (foundCharacter >= tLength) {
                int substringLength = rIdx - lIdx;
                if (minSubstringLength > substringLength) {
                    minSubstringLength = substringLength;
                    lIdxForMinSubstring = lIdx;
                    rIdxForMinSubstring = rIdx;
                    if (minSubstringLength == tLength) {
                        break;
                    }
                }
            }
        }

        return (minSubstringLength != Integer.MAX_VALUE) ? s.substring(lIdxForMinSubstring, rIdxForMinSubstring) : "";
    }
}
