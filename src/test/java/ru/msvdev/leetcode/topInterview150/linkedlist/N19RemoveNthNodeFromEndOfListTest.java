package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N19RemoveNthNodeFromEndOfListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeNthFromEnd(int[] head, int n, int[] out) {
        // region Given
        var solution = new N19RemoveNthNodeFromEndOfList();
        var list = LinkedListUtils.mapToList(head);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.removeNthFromEnd(list, n);
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
                        new int[]{1, 2, 3, 4}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{1, 2, 3, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        3,
                        new int[]{1, 2, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        4,
                        new int[]{1, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        5,
                        new int[]{2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{1},
                        1,
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{1, 2},
                        1,
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{1, 2},
                        2,
                        new int[]{2}
                )
        );
    }
}