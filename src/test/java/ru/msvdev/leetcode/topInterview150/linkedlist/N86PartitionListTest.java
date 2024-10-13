package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N86PartitionListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void partition(int[] head, int x, int[] out) {
        // region Given
        var solution = new N86PartitionList();
        var list = LinkedListUtils.mapToList(head);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.partition(list, x);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(outList, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 4, 3, 2, 5, 2},
                        30,
                        new int[]{1, 4, 3, 2, 5, 2}
                ),
                Arguments.of(
                        new int[]{1, 4, 3, 2, 5, 2},
                        -30,
                        new int[]{1, 4, 3, 2, 5, 2}
                ),
                Arguments.of(
                        new int[]{1, 4, 3, 2, 5, 2},
                        3,
                        new int[]{1, 2, 2, 4, 3, 5}
                ),
                Arguments.of(
                        new int[]{1, 4, 3, 0, 2, 5, 2},
                        3,
                        new int[]{1, 0, 2, 2, 4, 3, 5}
                ),
                Arguments.of(
                        new int[]{3, 6, 5, 2, 4, 8, 1, 7},
                        4,
                        new int[]{3, 2, 1, 6, 5, 4, 8, 7}
                ),
                Arguments.of(
                        new int[]{2, 2, 3, 1, 5, 0},
                        3,
                        new int[]{2, 2, 1, 0, 3, 5}
                ),
                Arguments.of(
                        new int[]{2, 1},
                        2,
                        new int[]{1, 2}
                ),
                Arguments.of(
                        new int[]{},
                        2,
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{1},
                        2,
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{3, 6, 5, 4, 8, 1, 7, 2, 4, 5, 6, 7, 2, 1, 2, 3, 4, 5, 77, 88, 3, 3, 3, 4, 4, 4},
                        4,
                        new int[]{3, 1, 2, 2, 1, 2, 3, 3, 3, 3, 6, 5, 4, 8, 7, 4, 5, 6, 7, 4, 5, 77, 88, 4, 4, 4}
                ),
                Arguments.of(
                        new int[]{3, 1},
                        2,
                        new int[]{1, 3}
                ),
                Arguments.of(
                        new int[]{2, 4, 1, 1, 2, 3, 4, 2, 2},
                        3,
                        new int[]{2, 1, 1, 2, 2, 2, 4, 3, 4}
                ),
                Arguments.of(
                        new int[]{2, 0, 4, 1, 3, 1, 4, 0, 3},
                        4,
                        new int[]{2, 0, 1, 3, 1, 0, 3, 4, 4}
                )
        );
    }
}