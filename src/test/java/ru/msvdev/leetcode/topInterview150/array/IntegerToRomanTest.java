package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class IntegerToRomanTest {

    @ParameterizedTest
    @MethodSource("intToRomanTestData")
    void intToRoman(int input, String output) {
        // region Given
        IntegerToRoman integerToRoman = new IntegerToRoman();
        // endregion


        // region When
        String string = integerToRoman.intToRoman(input);
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