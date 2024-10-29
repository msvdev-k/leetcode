package ru.msvdev.leetcode.topInterview150.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N289GameOfLifeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void gameOfLife(int[][] board, int[][] out) {
        // region Given
        var solution = new N289GameOfLife();
        // endregion

        // region When
        solution.gameOfLife(board);
        // endregion

        // region Then
        Assertions.assertArrayEquals(out, board);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}},
                        new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}}
                ),
                Arguments.of(
                        new int[][]{{1, 1}, {1, 0}},
                        new int[][]{{1, 1}, {1, 1}}
                )
        );
    }
}