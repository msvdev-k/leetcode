package ru.msvdev.leetcode.topInterview150.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * <p>
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly
 * maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
 * does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots
 * on the right.
 * <p>
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * <p>
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * <p>
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line
 * must be left-justified instead of fully-justified. Note that the second line is also left-justified
 * because it contains only one word.
 * <p>
 * Example 3:
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * <p>
 * Constraints:
 * -- 1 <= words.length <= 300
 * -- 1 <= words[i].length <= 20
 * -- words[i] consists of only English letters and symbols.
 * -- 1 <= maxWidth <= 100
 * -- words[i].length <= maxWidth
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(maxWidth);

        int totalWordCount = words.length;
        int indexOfFirstWordInLine = 0;

        while (true) {
            int wordCountInLine = 0;
            int allWordLengthsInLineWithoutSpaces = 0;

            int testLengthOfLine = words[indexOfFirstWordInLine].length();
            int currentIdx = indexOfFirstWordInLine;

            // Total words in line
            while (testLengthOfLine <= maxWidth) {
                wordCountInLine++;
                allWordLengthsInLineWithoutSpaces += words[currentIdx].length();

                currentIdx++;
                if (currentIdx >= totalWordCount) {
                    break;
                }

                testLengthOfLine += 1 + words[currentIdx].length();
            }


            stringBuilder.append(words[indexOfFirstWordInLine]);

            if (currentIdx < totalWordCount) {
                // Intermediate line

                int totalSpaceCountInLine = maxWidth - allWordLengthsInLineWithoutSpaces;

                if (wordCountInLine == 1) {
                    for (int i = 0; i < totalSpaceCountInLine; i++) {
                        stringBuilder.append(' ');
                    }

                } else {
                    int spaceCountBetweenWord = totalSpaceCountInLine / (wordCountInLine - 1);
                    int extraSpaceCount = totalSpaceCountInLine % (wordCountInLine - 1);

                    for (int i = indexOfFirstWordInLine + 1; i < indexOfFirstWordInLine + wordCountInLine; i++) {
                        for (int j = 0; j < spaceCountBetweenWord; j++) {
                            stringBuilder.append(' ');
                        }
                        if (extraSpaceCount > 0) {
                            stringBuilder.append(' ');
                            extraSpaceCount--;
                        }
                        stringBuilder.append(words[i]);
                    }
                }

                indexOfFirstWordInLine += wordCountInLine;

                out.add(stringBuilder.toString());
                stringBuilder.setLength(0);

            } else {
                // Finish line

                for (int i = indexOfFirstWordInLine + 1; i < indexOfFirstWordInLine + wordCountInLine; i++) {
                    stringBuilder.append(' ');
                    stringBuilder.append(words[i]);
                }

                for (int i = stringBuilder.length(); i < maxWidth; i++) {
                    stringBuilder.append(' ');
                }

                out.add(stringBuilder.toString());
                break;
            }
        }

        return out;
    }
}
