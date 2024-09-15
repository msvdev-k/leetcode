package ru.msvdev.leetcode.topInterview150.array;

public class LengthOfLastWord {

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
