package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.Arrays;

/**
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed
 * by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * <p>
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * <p>
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * Constraints:
 * -- 1 <= ransomNote.length, magazine.length <= 105
 * -- ransomNote and magazine consist of lowercase English letters.
 */
public class N383RansomNote {

    private static final int CHAR_OFFSET = 'a';

    public boolean canConstruct(String ransomNote, String magazine) {
        final int ransomNoteLength = ransomNote.length();
        final int magazineLength = magazine.length();
        if (ransomNoteLength > magazineLength) return false;

        final int[] charMap = new int[32];
        Arrays.fill(charMap, 0);
        for (int i = 0; i < magazineLength; i++) {
            final int chIdx = (int) magazine.charAt(i) - CHAR_OFFSET;
            charMap[chIdx]++;
        }

        for (int i = 0; i < ransomNoteLength; i++) {
            final int chIdx = (int) ransomNote.charAt(i) - CHAR_OFFSET;
            charMap[chIdx]--;
            if (charMap[chIdx] < 0) return false;
        }

        return true;
    }
}
