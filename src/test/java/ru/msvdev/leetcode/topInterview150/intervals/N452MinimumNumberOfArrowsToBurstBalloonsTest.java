package ru.msvdev.leetcode.topInterview150.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N452MinimumNumberOfArrowsToBurstBalloonsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMinArrowShots1(int[][] points, int out) {
        // region Given
        var solution = new N452MinimumNumberOfArrowsToBurstBalloons();
        // endregion

        // region When
        var answer = solution.findMinArrowShots1(points);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findMinArrowShots2(int[][] points, int out) {
        // region Given
        var solution = new N452MinimumNumberOfArrowsToBurstBalloons();
        // endregion

        // region When
        var answer = solution.findMinArrowShots2(points);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}},
                        2
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}},
                        4
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                        2
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}},
                        3
                ),
                Arguments.of(
                        new int[][]{{0, 10}, {20, 30}, {40, 50}, {60, 70}},
                        4
                ),
                Arguments.of(
                        new int[][]{{-10, -5}, {-7, 0}, {2, 5}, {7, 10}},
                        3
                ),
                Arguments.of(
                        new int[][]{{100, 200}, {150, 250}, {180, 220}, {210, 230}},
                        2
                ),
                Arguments.of(
                        new int[][]{{-50, -40}, {-30, -20}, {-10, 0}, {10, 20}, {30, 40}},
                        5
                ),
                Arguments.of(
                        new int[][]{{500, 510}, {520, 530}, {540, 550}, {560, 570}, {580, 590}},
                        5
                ),
                Arguments.of(
                        new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}},
                        3
                ),
                Arguments.of(
                        new int[][]{{10, 20}, {30, 40}, {50, 60}, {70, 80}, {90, 100}},
                        5
                ),
                Arguments.of(
                        new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}},
                        2
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                        2
                ),
                Arguments.of(
                        new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}},
                        2
                ),
                Arguments.of(
                        new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}},
                        2
                ),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}},
                        4
                ),
                Arguments.of(
                        new int[][]{{1, 2}},
                        1
                ),
                Arguments.of(
                        new int[][]{{2, 3}, {2, 3}},
                        1
                )
        );
    }
}
