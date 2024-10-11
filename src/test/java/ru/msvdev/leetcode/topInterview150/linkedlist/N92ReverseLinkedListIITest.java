package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N92ReverseLinkedListIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseBetween(int[] head, int left, int right, int[] out) {
        // region Given
        var solution = new N92ReverseLinkedListII();
        var list = LinkedListUtils.mapToList(head);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.reverseBetween(list, left, right);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(outList, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        2, 4,
                        new int[]{1, 4, 3, 2, 5}
                ),
                Arguments.of(
                        new int[]{5},
                        1, 1,
                        new int[]{5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        1, 4,
                        new int[]{4, 3, 2, 1}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        2, 3,
                        new int[]{1, 3, 2, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        2, 2,
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        1, 4,
                        new int[]{4, 3, 2, 1, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        1, 5,
                        new int[]{5, 4, 3, 2, 1}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        5, 5,
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2},
                        1, 2,
                        new int[]{2, 1}
                )
        );
    }
}