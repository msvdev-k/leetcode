package ru.msvdev.leetcode.topInterview150.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N73SetMatrixZeroesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void setZeroes1(int[][] matrix, int[][] out) {
        // region Given
        var solution = new N73SetMatrixZeroes();
        // endregion

        // region When
        solution.setZeroes1(matrix);
        // endregion

        // region Then
        Assertions.assertArrayEquals(out, matrix);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void setZeroes2(int[][] matrix, int[][] out) {
        // region Given
        var solution = new N73SetMatrixZeroes();
        // endregion

        // region When
        solution.setZeroes2(matrix);
        // endregion

        // region Then
        Assertions.assertArrayEquals(out, matrix);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                        new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}
                ),
                Arguments.of(
                        new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}},
                        new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}
                ),
                Arguments.of(
                        new int[][]{{0}, {1}, {1}},
                        new int[][]{{0}, {0}, {0}}
                )
        );
    }
}