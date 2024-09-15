package ru.msvdev.leetcode.topInterview150.array;


/**
 * 28. Find the Index of the First Occurrence in a String
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * Constraints:
 * -- 1 <= haystack.length, needle.length <= 104
 * -- haystack and needle consist of only lowercase English characters.
 */
public class FindIndexOfFirstOccurrenceInString {

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean occurrenceFlag = true;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    occurrenceFlag = false;
                    break;
                }
            }

            if (occurrenceFlag) {
                return i;
            }
        }

        return -1;
    }
}
