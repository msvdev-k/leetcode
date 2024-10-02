package ru.msvdev.leetcode.topInterview150.slidingwindow;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * <p>
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * <p>
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd",
 * and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not
 * the concatenation of any permutation of words.
 * <p>
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer
 * in any order.
 * <p>
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation:
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * <p>
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation:
 * There is no concatenated substring.
 * <p>
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation:
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 * <p>
 * Constraints:
 * -- 1 <= s.length <= 104
 * -- 1 <= words.length <= 5000
 * -- 1 <= words[i].length <= 30
 * -- s and words[i] consist of lowercase English letters.
 */
public class N30SubstringWithConcatenationOfAllWords {

    private static final int WORD_COUNT_IDX = 0;

    public List<Integer> findSubstring(String s, String[] words) {
        final int stringLength = s.length();
        final int stepSize = words[0].length();
        final int stepsInWindow = words.length;
        final int windowSize = stepSize * stepsInWindow;
        if (windowSize > stringLength) return new ArrayList<>();

        final Map<String, int[]> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.get(word)[WORD_COUNT_IDX]++;
            } else {
                int[] counter = new int[stepSize + 1];
                Arrays.fill(counter, 0);
                counter[WORD_COUNT_IDX] = 1;
                wordMap.put(word, counter);
            }
        }

        final List<Integer> startingIndices = new ArrayList<>();

        int[] foundWordsInWindow = new int[stepSize];
        Arrays.fill(foundWordsInWindow, 0);

        for (int lStepNumber = 0, rStepNumber = 0; rStepNumber < stringLength; rStepNumber += stepSize) {
            for (int windowNumber = 0; windowNumber < stepSize; windowNumber++) {
                int beginSubstringIdx = rStepNumber + windowNumber;
                int endSubstringIdx = beginSubstringIdx + stepSize;
                if (endSubstringIdx > stringLength) break;

                String wordFromString = s.substring(beginSubstringIdx, endSubstringIdx);
                if (wordMap.containsKey(wordFromString)) {
                    int[] counter = wordMap.get(wordFromString);
                    counter[windowNumber + 1]++;
                    if (counter[windowNumber + 1] <= counter[WORD_COUNT_IDX]) {
                        foundWordsInWindow[windowNumber]++;
                    }
                }
            }

            while (rStepNumber - lStepNumber + 1 > windowSize) {
                for (int windowNumber = 0; windowNumber < stepSize; windowNumber++) {
                    int beginSubstringIdx = lStepNumber + windowNumber;
                    int endSubstringIdx = beginSubstringIdx + stepSize;
                    if (endSubstringIdx > stringLength) break;

                    String wordFromString = s.substring(beginSubstringIdx, endSubstringIdx);
                    if (wordMap.containsKey(wordFromString)) {
                        int[] counter = wordMap.get(wordFromString);
                        counter[windowNumber + 1]--;
                        if (counter[windowNumber + 1] < counter[WORD_COUNT_IDX]) {
                            foundWordsInWindow[windowNumber]--;
                        }
                    }
                }
                lStepNumber += stepSize;
            }

            for (int windowNumber = 0; windowNumber < stepSize; windowNumber++) {
                if (foundWordsInWindow[windowNumber] == stepsInWindow) {
                    startingIndices.add(lStepNumber + windowNumber);
                }
            }
        }

        return startingIndices;
    }

}
