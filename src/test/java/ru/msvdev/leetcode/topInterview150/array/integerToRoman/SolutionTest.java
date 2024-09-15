package ru.msvdev.leetcode.topInterview150.array.integerToRoman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @ParameterizedTest
    @MethodSource("intToRomanTestData")
    void intToRoman(int input, String output) {
        // region Given
        Solution solution = new Solution();
        // endregion


        // region When
        String string = solution.intToRoman(input);
        // endregion


        // region Then
        assertEquals(output, string);
        // endregion
    }


    private static Stream<Arguments> intToRomanTestData() {
        return Stream.of(
                Arguments.of(3749, "MMMDCCXLIX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }
}