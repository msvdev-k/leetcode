package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N201BitwiseANDofNumbersRangeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rangeBitwiseAnd1(int left, int right, int out) {
        // region Given
        var solution = new N201BitwiseANDofNumbersRange();
        // endregion

        // region When
        var answer = solution.rangeBitwiseAnd1(left, right);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void rangeBitwiseAnd2(int left, int right, int out) {
        // region Given
        var solution = new N201BitwiseANDofNumbersRange();
        // endregion

        // region When
        var answer = solution.rangeBitwiseAnd2(left, right);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 7, 4),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 2147483647, 0),
                Arguments.of(2147483646, 2147483647, 2147483646),
                Arguments.of(1073741824, 2147483647, 1073741824)
        );
    }
}