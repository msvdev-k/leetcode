package ru.msvdev.leetcode.topInterview150.intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class N57InsertIntervalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void insert1(int[][] intervals, int[] newInterval, int[][] out) {
        // region Given
        var solution = new N57InsertInterval();
        // endregion

        // region When
        var answer = solution.insert1(intervals, newInterval);
        // endregion

        // region Then
//        System.out.println(Arrays.deepToString(answer));
        assertEquals(out.length, answer.length);
        for (int i = 0; i < out.length; i++) {
            assertArrayEquals(out[i], answer[i]);
        }
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void insert2(int[][] intervals, int[] newInterval, int[][] out) {
        // region Given
        var solution = new N57InsertInterval();
        // endregion

        // region When
        var answer = solution.insert2(intervals, newInterval);
        // endregion

        // region Then
//        System.out.println(Arrays.deepToString(answer));
        assertEquals(out.length, answer.length);
        for (int i = 0; i < out.length; i++) {
            assertArrayEquals(out[i], answer[i]);
        }
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5},
                        new int[][]{{1, 5}, {6, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 9},
                        new int[][]{{1, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}}
                ),
                Arguments.of(
                        new int[][]{{2, 4}, {5, 7}, {8, 10}, {11, 13}},
                        new int[]{3, 6},
                        new int[][]{{2, 7}, {8, 10}, {11, 13}}
                ),
                Arguments.of(
                        new int[][]{{0, 0}, {2, 4}, {9, 9}},
                        new int[]{0, 7},
                        new int[][]{{0, 7}, {9, 9}}
                ),
                Arguments.of(
                        new int[][]{{0, 10}, {14, 14}, {15, 20}},
                        new int[]{11, 11},
                        new int[][]{{0, 10}, {11, 11}, {14, 14}, {15, 20}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {5, 6}},
                        new int[]{2, 5},
                        new int[][]{{1, 6}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {5, 6}},
                        new int[]{2, 10},
                        new int[][]{{1, 10}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {4, 4}, {5, 5}},
                        new int[]{3, 3},
                        new int[][]{{1, 3}, {4, 4}, {5, 5}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}}
                ),
                Arguments.of(
                        new int[][]{},
                        new int[]{5, 7},
                        new int[][]{{5, 7}}
                ),
                Arguments.of(
                        new int[][]{},
                        new int[]{2, 5},
                        new int[][]{{2, 5}}
                ),
                Arguments.of(
                        new int[][]{{3, 5}, {8, 10}},
                        new int[]{1, 2},
                        new int[][]{{1, 2}, {3, 5}, {8, 10}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{11, 12},
                        new int[][]{{1, 3}, {6, 9}, {11, 12}}
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {8, 10}},
                        new int[]{2, 9},
                        new int[][]{{1, 10}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 7},
                        new int[][]{{1, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{4, 7},
                        new int[][]{{1, 3}, {4, 9}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{3, 6},
                        new int[][]{{1, 9}}
                )
        );
    }
}
