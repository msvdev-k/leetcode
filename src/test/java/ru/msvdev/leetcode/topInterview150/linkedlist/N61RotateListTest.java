package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N61RotateListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rotateRight1(int[] head, int k, int[] out) {
        // region Given
        var solution = new N61RotateList();
        var list = LinkedListUtils.mapToList(head);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.rotateRight1(list, k);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(outList, answer));
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void rotateRight2(int[] head, int k, int[] out) {
        // region Given
        var solution = new N61RotateList();
        var list = LinkedListUtils.mapToList(head);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.rotateRight2(list, k);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(outList, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        1,
                        new int[]{5, 1, 2, 3, 4}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{4, 5, 1, 2, 3}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        3,
                        new int[]{3, 4, 5, 1, 2}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        4,
                        new int[]{2, 3, 4, 5, 1}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        5,
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{0, 1, 2},
                        4,
                        new int[]{2, 0, 1}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        27,
                        new int[]{4, 5, 1, 2, 3}
                )
        );
    }
}