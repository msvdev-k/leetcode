package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagConversionTest {


    @ParameterizedTest
    @MethodSource("convertTestData")
    void convert(String input, int numRows, String output) {
        // region Given
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        // endregion


        // region When
        String zigzagString = zigzagConversion.convert(input, numRows);
        // endregion


        // region Then
        assertEquals(output, zigzagString);
        // endregion
    }


    private static Stream<Arguments> convertTestData() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A")
        );
    }
}