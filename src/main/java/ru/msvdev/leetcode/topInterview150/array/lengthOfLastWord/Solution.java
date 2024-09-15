package ru.msvdev.leetcode.topInterview150.array.lengthOfLastWord;

public class Solution {

    public int lengthOfLastWord(String s) {
        int wordLength = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                wordLength++;
            } else if (wordLength > 0) {
                break;
            }
        }

        return wordLength;
    }
}
