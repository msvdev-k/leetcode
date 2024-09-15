package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIndexOfFirstOccurrenceInStringTest {

    @ParameterizedTest
    @MethodSource("strStrTestData")
    void strStr1(String haystack, String needle, int output) {
        // region Given
        FindIndexOfFirstOccurrenceInString solution = new FindIndexOfFirstOccurrenceInString();
        // endregion


        // region When
        int index = solution.strStr1(haystack, needle);
        // endregion


        // region Then
        assertEquals(output, index);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("strStrTestData")
    void strStr2(String haystack, String needle, int output) {
        // region Given
        FindIndexOfFirstOccurrenceInString solution = new FindIndexOfFirstOccurrenceInString();
        // endregion


        // region When
        int index = solution.strStr2(haystack, needle);
        // endregion


        // region Then
        assertEquals(output, index);
        // endregion
    }


    private static Stream<Arguments> strStrTestData() {
        return Stream.of(
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("leetcode", "etc", 2)
        );
    }
}