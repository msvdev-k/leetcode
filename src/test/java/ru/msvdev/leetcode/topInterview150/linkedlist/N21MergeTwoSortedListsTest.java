package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N21MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeTwoLists(int[] l1, int[] l2, int[] out) {
        // region Given
        var solution = new N21MergeTwoSortedLists();
        var list1 = LinkedListUtils.mapToList(l1);
        var list2 = LinkedListUtils.mapToList(l2);
        var outList = LinkedListUtils.mapToList(out);
        // endregion

        // region When
        var answer = solution.mergeTwoLists(list1, list2);
        // endregion

        // region Then
        Assertions.assertTrue(LinkedListUtils.compareList(outList, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 4},
                        new int[]{1, 3, 4},
                        new int[]{1, 1, 2, 3, 4, 4}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{0},
                        new int[]{0}
                ),
                Arguments.of(
                        new int[]{1},
                        new int[]{2},
                        new int[]{1, 2}
                )
        );
    }
}