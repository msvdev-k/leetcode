package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N82RemoveDuplicatesFromSortedListIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteDuplicates(int[] head, int[] out) {
        // region Given
        var solution = new N82RemoveDuplicatesFromSortedListII();
        var list = LinkedListUtils.mapToList(head);
        var listOut = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.deleteDuplicates(list);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(listOut, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 3, 4, 4, 5},
                        new int[]{1, 2, 5}
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 2, 3},
                        new int[]{2, 3}
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{1, 1},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{1, 2, 2},
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{-3, -1, 0, 0, 0, 3, 3},
                        new int[]{-3, -1}
                )
        );
    }
}