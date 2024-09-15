package ru.msvdev.leetcode.topInterview150.array.longestCommonPrefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        char[] prefix = strs[0].toCharArray();
        int prefixLength = prefix.length;

        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            int currentStringLength = currentString.length();

            if (currentStringLength < prefixLength) {
                prefixLength = currentStringLength;
            }

            for (int j = 0; j < prefixLength; j++) {
                if (currentString.charAt(j) != prefix[j]) {
                    prefixLength = j;
                    break;
                }
            }

            if (prefixLength == 0) {
                return "";
            }
        }

        return new String(prefix, 0, prefixLength);
    }
}
