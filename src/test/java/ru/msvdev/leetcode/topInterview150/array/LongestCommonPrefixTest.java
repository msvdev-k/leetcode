package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    @ParameterizedTest
    @MethodSource("longestCommonPrefixTestData")
    void longestCommonPrefix(String[] input, String output) {
        // region Given
        LongestCommonPrefix solution = new LongestCommonPrefix();
        // endregion


        // region When
        String longestCommonPrefix = solution.longestCommonPrefix(input);
        // endregion


        // region Then
        assertEquals(output, longestCommonPrefix);
        // endregion
    }

    private static Stream<Arguments> longestCommonPrefixTestData() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }
}