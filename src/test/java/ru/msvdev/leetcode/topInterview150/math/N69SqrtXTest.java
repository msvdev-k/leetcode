package ru.msvdev.leetcode.topInterview150.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N69SqrtXTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mySqrt1(int x, int out) {
        // region Given
        var solution = new N69SqrtX();
        // endregion

        // region When
        var answer = solution.mySqrt1(x);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void mySqrt2(int x, int out) {
        // region Given
        var solution = new N69SqrtX();
        // endregion

        // region When
        var answer = solution.mySqrt2(x);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 1),
                Arguments.of(4, 2),
                Arguments.of(8, 2),
                Arguments.of(2147483647, 46340),
                Arguments.of(2147395600, 46340),
                Arguments.of(2147395599, 46339)
        );
    }
}