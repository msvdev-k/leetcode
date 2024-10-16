package ru.msvdev.leetcode.topInterview150.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N172FactorialTrailingZeroesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void trailingZeroes1(int n, int out) {
        // region Given
        var solution = new N172FactorialTrailingZeroes();
        // endregion

        // region When
        var answer = solution.trailingZeroes1(n);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void trailingZeroes2(int n, int out) {
        // region Given
        var solution = new N172FactorialTrailingZeroes();
        // endregion

        // region When
        var answer = solution.trailingZeroes2(n);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void trailingZeroes3(int n, int out) {
        // region Given
        var solution = new N172FactorialTrailingZeroes();
        // endregion

        // region When
        var answer = solution.trailingZeroes3(n);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(5, 1),
                Arguments.of(0, 0),
                Arguments.of(59, 13),
                Arguments.of(10_000, 2499)
        );
    }
}