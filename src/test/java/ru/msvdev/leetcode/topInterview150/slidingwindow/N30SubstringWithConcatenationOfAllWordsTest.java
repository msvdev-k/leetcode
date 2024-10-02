package ru.msvdev.leetcode.topInterview150.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class N30SubstringWithConcatenationOfAllWordsTest {

    @ParameterizedTest
    @MethodSource("findSubstringTestData")
    void findSubstring(String s, String[] words, int[] out) {
        // region Given
        N30SubstringWithConcatenationOfAllWords solution = new N30SubstringWithConcatenationOfAllWords();
        // endregion


        // region When
        List<Integer> substrings = solution.findSubstring(s, words);
        // endregion


        // region Then
        assertArrayEquals(out, substrings.stream().mapToInt(Integer::intValue).toArray());
        // endregion
    }


    private static Stream<Arguments> findSubstringTestData() {
        return Stream.of(
                Arguments.of(
                        "barfoothefoobarman",
                        new String[]{"foo", "bar"},
                        new int[]{0, 9}
                ),
                Arguments.of(
                        "wordgoodgoodgoodbestword",
                        new String[]{"word", "good", "best", "word"},
                        new int[0]
                ),
                Arguments.of(
                        "barfoofoobarthefoobarman",
                        new String[]{"bar", "foo", "the"},
                        new int[]{6, 9, 12}
                ),
                Arguments.of(
                        "barfoofoobarthefoobarman",
                        new String[]{"bar", "foo", "the", "foo"},
                        new int[]{3, 6}
                ),
                Arguments.of(
                        "aaaaaaa",
                        new String[]{"aa"},
                        new int[]{0, 1, 2, 3, 4, 5}
                )
        );
    }
}