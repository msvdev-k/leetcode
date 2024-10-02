package ru.msvdev.leetcode.topInterview150.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N76MinimumWindowSubstringTest {

    @ParameterizedTest
    @MethodSource("minWindowTestData")
    void minWindow1(String s, String t, String out) {
        // region Given
        N76MinimumWindowSubstring solution = new N76MinimumWindowSubstring();
        // endregion


        // region When
        String minWindow = solution.minWindow1(s, t);
        // endregion


        // region Then
        assertEquals(out, minWindow);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("minWindowTestData")
    void minWindow2(String s, String t, String out) {
        // region Given
        N76MinimumWindowSubstring solution = new N76MinimumWindowSubstring();
        // endregion


        // region When
        String minWindow = solution.minWindow2(s, t);
        // endregion


        // region Then
        assertEquals(out, minWindow);
        // endregion
    }


    private static Stream<Arguments> minWindowTestData() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "aa", ""),
                Arguments.of("aaaaaaaaaaaabbbbbcdd", "abcdd", "abbbbbcdd"),
                Arguments.of("ab", "a", "a")
        );
    }
}