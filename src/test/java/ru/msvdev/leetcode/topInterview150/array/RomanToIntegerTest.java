package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RomanToIntegerTest {

    @ParameterizedTest
    @MethodSource("romanToIntTestData")
    void romanToInt(String s, int num) {
        // region Given
        RomanToInteger romanToInteger = new RomanToInteger();
        // endregion


        // region When
        int integer = romanToInteger.romanToInt(s);
        // endregion


        // region Then
        assertEquals(num, integer);
        // endregion
    }


    private static Stream<Arguments> romanToIntTestData() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
        );
    }
}