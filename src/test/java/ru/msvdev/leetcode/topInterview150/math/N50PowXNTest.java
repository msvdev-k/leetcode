package ru.msvdev.leetcode.topInterview150.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N50PowXNTest {

    private static final double EPS = 1e-14;

    @ParameterizedTest
    @MethodSource("testData")
    void myPow1(double x, int n, double out) {
        // region Given
        var solution = new N50PowXN();
        // endregion

        // region When
        var answer = solution.myPow1(x, n);
        // endregion

        // region Then
        System.out.println(out - answer);
        Assertions.assertEquals(out, answer, EPS);

        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void myPow2(double x, int n, double out) {
        // region Given
        var solution = new N50PowXN();
        // endregion

        // region When
        var answer = solution.myPow2(x, n);
        // endregion

        // region Then
        System.out.println(out - answer);
        Assertions.assertEquals(out, answer, EPS);

        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2.0, 10, 1024.0),
                Arguments.of(2.1, 3, 9.261),
                Arguments.of(2.0, -2, 0.25),
                Arguments.of(2.0, 2, 4.0),
                Arguments.of(-1.0, 2147483647, -1.0),
                Arguments.of(2.0, -2147483648, 0.0),
                Arguments.of(0.00001, 2147483647, 0.0)
        );
    }
}