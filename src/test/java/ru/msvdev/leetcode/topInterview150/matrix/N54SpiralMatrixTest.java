package ru.msvdev.leetcode.topInterview150.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N54SpiralMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void spiralOrder(int[][] matrix, int[] out) {
        // region Given
        var solution = new N54SpiralMatrix();
        // endregion

        // region When
        var answer = solution.spiralOrder(matrix);
        // endregion

        // region Then
        List<Integer> outListlist = Arrays.stream(out).boxed().toList();
        assertEquals(outListlist, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        new int[]{1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10}
                )
        );
    }
}