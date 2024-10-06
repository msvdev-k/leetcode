package ru.msvdev.leetcode.topInterview150.intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class N56MergeIntervalsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void merge(int[][] intervals, int[][] out) {
        // region Given
        var solution = new N56MergeIntervals();
        // endregion

        // region When
        var answer = solution.merge(intervals);
        // endregion

        // region Then
        System.out.println(Arrays.deepToString(answer));
        assertEquals(out.length, answer.length);
        for (int i = 0; i < out.length; i++) {
            assertArrayEquals(out[i], answer[i]);
        }
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                        new int[][]{{1, 6}, {8, 10}, {15, 18}}
                ),
                Arguments.of(
                        new int[][]{{1, 4}, {4, 5}},
                        new int[][]{{1, 5}}
                ),
                Arguments.of(
                        new int[][]{{1, 4}, {0, 0}},
                        new int[][]{{0, 0}, {1, 4}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {8, 9}, {9, 11}, {15, 18}, {2, 4}, {16, 17}},
                        new int[][]{{1, 6}, {8, 11}, {15, 18}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}},
                        new int[][]{{1, 3}}
                )
        );
    }
}