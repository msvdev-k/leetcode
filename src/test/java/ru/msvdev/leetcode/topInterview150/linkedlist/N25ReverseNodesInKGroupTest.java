package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N25ReverseNodesInKGroupTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseKGroup(int[] head, int k, int[] out) {
        // region Given
        var solution = new N25ReverseNodesInKGroup();
        var list = LinkedListUtils.mapToList(head);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.reverseKGroup(list, k);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(outList, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{2, 1, 4, 3, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        3,
                        new int[]{3, 2, 1, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        4,
                        new int[]{4, 3, 2, 1, 5}
                )
        );
    }
}