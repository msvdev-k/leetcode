package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Constraints:
 * -- 1 <= s.length, t.length <= 5 * 10^4
 * -- s and t consist of lowercase English letters.
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution
 * to such a case?
 */
public class N242ValidAnagram {

    private static final int CHAR_OFFSET = 'a';
    private static final int COUNT_OF_CHARACTER = 26;

    public boolean isAnagram1(String s, String t) {
        final int sLength = s.length();
        final int tLength = t.length();
        if (sLength != tLength) return false;

        final int[] countOfChars = new int[COUNT_OF_CHARACTER];
        Arrays.fill(countOfChars, 0);
        for (int i = 0; i < sLength; i++) {
            final int idx = (int) s.charAt(i) - CHAR_OFFSET;
            countOfChars[idx]++;
        }
        for (int i = 0; i < tLength; i++) {
            final int idx = (int) t.charAt(i) - CHAR_OFFSET;
            final int charCount = countOfChars[idx];
            if (charCount > 0) {
                countOfChars[idx]--;
            } else {
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, int[]> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (characterMap.containsKey(ch)) {
                characterMap.get(ch)[0]++;
            } else {
                characterMap.put(ch, new int[]{1});
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (characterMap.containsKey(ch)) {
                int[] count = characterMap.get(ch);
                if (count[0] > 0) {
                    count[0]--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
