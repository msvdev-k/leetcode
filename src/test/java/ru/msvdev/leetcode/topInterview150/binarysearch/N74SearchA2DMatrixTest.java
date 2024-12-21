package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N74SearchA2DMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchMatrix(int[][] matrix, int target, boolean out) {
        // region Given
        var solution = new N74SearchA2DMatrix();
        // endregion

        // region When
        var answer = solution.searchMatrix(matrix, target);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                        3, true
                ),
                Arguments.of(
                        new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                        13, false
                ),
                Arguments.of(
                        new int[][]{{1}, {3}, {5}},
                        3, true
                ),
                Arguments.of(
                        new int[][]{{1, 3}},
                        3, true
                ),
                Arguments.of(
                        new int[][]{{1, 3}},
                        2, false
                ),
                Arguments.of(
                        new int[][]{{1}},
                        1, true
                ),
                Arguments.of(
                        new int[][]{{1}},
                        0, false
                ),
                Arguments.of(
                        new int[][]{{1}},
                        2, false
                ),
                Arguments.of(
                        new int[][]{{1},{3}},
                        3, true
                )
        );
    }
}