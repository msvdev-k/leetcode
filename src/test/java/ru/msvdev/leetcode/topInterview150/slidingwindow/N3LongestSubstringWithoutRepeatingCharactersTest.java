package ru.msvdev.leetcode.topInterview150.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N3LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubstringTestData")
    void lengthOfLongestSubstring(String s, int out) {
        // region Given
        N3LongestSubstringWithoutRepeatingCharacters solution = new N3LongestSubstringWithoutRepeatingCharacters();
        // endregion


        // region When
        int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(s);
        // endregion


        // region Then
        assertEquals(out, lengthOfLongestSubstring);
        // endregion
    }

    private static Stream<Arguments> lengthOfLongestSubstringTestData() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("qwertyuiopasdfghjk", 18),
                Arguments.of("", 0)
        );
    }
}