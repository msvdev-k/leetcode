package ru.msvdev.leetcode.topInterview150.array.lengthOfLastWord;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("lengthOfLastWordTestData")
    void lengthOfLastWord(String input, int output) {
        // region Given
        Solution solution = new Solution();
        // endregion


        // region When
        int lengthOfLastWord = solution.lengthOfLastWord(input);
        // endregion


        // region Then
        assertEquals(output, lengthOfLastWord);
        // endregion
    }

    private static Stream<Arguments> lengthOfLastWordTestData() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of("still", 5),
                Arguments.of(" ", 0)
        );
    }
}