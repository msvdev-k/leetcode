package ru.msvdev.leetcode.topInterview150.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N149MaxPointsOnALineTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxPoints1(int[][] points, int out) {
        // region Given
        var solution = new N149MaxPointsOnALine();
        // endregion

        // region When
        var answer = solution.maxPoints1(points);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void maxPoints2(int[][] points, int out) {
        // region Given
        var solution = new N149MaxPointsOnALine();
        // endregion

        // region When
        var answer = solution.maxPoints2(points);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 1}, {2, 2}, {3, 3}},
                        3
                ),
                Arguments.of(
                        new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}},
                        4
                ),
                Arguments.of(
                        new int[][]{{0, 0}, {94911151, 94911150}, {94911152, 94911151}},
                        2
                )
        );
    }
}