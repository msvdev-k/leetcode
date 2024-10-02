package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 290. Word Pattern
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter
 * in pattern and a non-empty word in s. Specifically:
 * -- Each letter in pattern maps to exactly one unique word in s.
 * -- Each unique word in s maps to exactly one letter in pattern.
 * -- No two letters map to the same word, and no two words map to the same letter.
 * <p>
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Explanation:
 * The bijection can be established as:
 * 'a' maps to "dog".
 * 'b' maps to "cat".
 * <p>
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * <p>
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * <p>
 * Constraints:
 * -- 1 <= pattern.length <= 300
 * -- pattern contains only lower-case English letters.
 * -- 1 <= s.length <= 3000
 * -- s contains only lowercase English letters and spaces ' '.
 * -- s does not contain any leading or trailing spaces.
 * -- All the words in s are separated by a single space.
 */
public class N290WordPattern {

    private static final int CHAR_OFFSET = 'a';
    private static final int COUNT_OF_CHARACTER = 26;

    public boolean wordPattern(String pattern, String s) {
        final int patternLength = pattern.length();
        final String[] words = s.split(" ");
        if (patternLength != words.length) return false;

        final String[] patternStrings = new String[COUNT_OF_CHARACTER];
        final Set<String> patternStringSet = new HashSet<>();

        for (int i = 0; i < patternLength; i++) {
            final int idx = (int) pattern.charAt(i) - CHAR_OFFSET;
            final String word = words[i];

            if (patternStrings[idx] == null && !patternStringSet.contains(word)) {
                patternStrings[idx] = word;
                patternStringSet.add(word);

            } else if (!word.equals(patternStrings[idx])) {
                return false;
            }
        }

        return true;
    }
}
