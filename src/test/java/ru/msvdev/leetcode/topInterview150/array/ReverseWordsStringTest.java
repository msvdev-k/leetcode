package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsStringTest {

    @ParameterizedTest
    @MethodSource("reverseWordsTestData")
    void reverseWords1(String input, String output) {
        // region Given
        ReverseWordsString reverseWordsString = new ReverseWordsString();
        // endregion


        // region When
        String reverseWords = reverseWordsString.reverseWords1(input);
        // endregion


        // region Then
        assertEquals(output, reverseWords);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("reverseWordsTestData")
    void reverseWords2(String input, String output) {
        // region Given
        ReverseWordsString reverseWordsString = new ReverseWordsString();
        // endregion


        // region When
        String reverseWords = reverseWordsString.reverseWords2(input);
        // endregion


        // region Then
        assertEquals(output, reverseWords);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("reverseWordsTestData")
    void reverseWords3(String input, String output) {
        // region Given
        ReverseWordsString reverseWordsString = new ReverseWordsString();
        // endregion


        // region When
        String reverseWords = reverseWordsString.reverseWords3(input);
        // endregion


        // region Then
        assertEquals(output, reverseWords);
        // endregion
    }


    private static Stream<Arguments> reverseWordsTestData() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }
}
