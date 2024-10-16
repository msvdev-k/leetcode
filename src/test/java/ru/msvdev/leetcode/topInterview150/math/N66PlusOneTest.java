package ru.msvdev.leetcode.topInterview150.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N66PlusOneTest {

    @ParameterizedTest
    @MethodSource("testData")
    void plusOne(int[] digits, int[] out) {
        // region Given
        var solution = new N66PlusOne();
        // endregion

        // region When
        var answer = solution.plusOne(digits);
        // endregion

        // region Then
        Assertions.assertArrayEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{1, 2, 4}
                ),
                Arguments.of(
                        new int[]{4, 3, 2, 1},
                        new int[]{4, 3, 2, 2}
                ),
                Arguments.of(
                        new int[]{9},
                        new int[]{1, 0}
                ),
                Arguments.of(
                        new int[]{0},
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}
                ),
                Arguments.of(
                        new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                        new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                ),
                Arguments.of(
                        new int[]{6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3},
                        new int[]{6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 4}
                )
        );
    }
}