package ru.msvdev.leetcode.topInterview150.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsString {

    public String reverseWords1(String s) {
        List<String> words = new ArrayList<>(
                Arrays.stream(s.split(" "))
                        .filter(word -> !word.isBlank())
                        .toList()
        );

        Collections.reverse(words);

        return String.join(" ", words);
    }


    public String reverseWords2(String s) {
        String[] words = s.split(" ");
        List<String> reverseWords = new ArrayList<>();

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isBlank()) {
                reverseWords.add(words[i]);
            }
        }

        return String.join(" ", reverseWords);
    }


    public String reverseWords3(String s) {
        char[] chars = s.toCharArray();
        int reverseStringLength = chars.length;

        // TODO: If the string data type is mutable in your language,
        // can you solve it in-place with O(1) extra space?

        return new String(chars, 0, reverseStringLength);
    }

}
